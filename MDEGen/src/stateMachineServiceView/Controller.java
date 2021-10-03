package stateMachineServiceView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import commands.Command;
import generated.stateMachineService.*;
import generated.stateMachineService.commands.Event_constructor_Command;
import generated.stateMachineService.commands.StateMachine_addState_Command;
import generated.stateMachineService.commands.StateMachine_addTransition_Command;
import generated.stateMachineService.commands.StateMachine_constructor_Command;
import generated.stateMachineService.commands.State_constructor_Command;
import generated.stateMachineService.proxies.IStateMachine;
import observation.Observer;
public class Controller implements Observer{
	private DefaultTreeModel snapshot;
	private StateMachineServiceView controlledView;
	private StateMachineService service;
	private DefaultMutableTreeNode root;
	public Controller() {
		this.setSystemLookAndFeel();
		this.controlledView = new StateMachineServiceView(this);
		this.root = new DefaultMutableTreeNode("ServiceRoot");
		this.snapshot = new DefaultTreeModel(root);
		this.controlledView.getJTree().setModel(this.snapshot);
		this.service = StateMachineService.getInstance();
		this.controlledView.getBtnInitialise().addActionListener(e->this.onInitialise());
		this.controlledView.getJTree().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleRightClick(e);
			}
		});
	}
	
	public void update(Command<?> command) {
		System.out.println("sm-object changed due to " + command.getClass().getName());
		this.createTree();
	}
	private <R> R createAndExecuteCommand(Command<R> command) throws Exception{
		command.execute();
		return command.getResult();
	}
// SIMULATION of definition dialog with fixed values	
	public void onInitialise() {
		String name = JOptionPane.showInputDialog(controlledView, "Enter name of new StateMachine");
		if(name == null) return;
		try {
// 1. Controller registers for events from service object		
			StateMachineService.getInstance().addObserver(this);
// 2. Construction of start state and state machine
			State z0 = this.createAndExecuteCommand(new State_constructor_Command(this.toOpt("z0"), false));
			StateMachine sm = this.createAndExecuteCommand(new StateMachine_constructor_Command(z0, name));
// 3. Controller registers for events from state machine sm		
			sm.addObserver(this);
// 4. This change is not reported since it can not be wrapped into a command (the command for adding a state is not appropriate since it creates a new state)
			sm.addToStates(z0);  
// 5. More object structure changes: 
			State z1 = this.createAndExecuteCommand(new State_constructor_Command(this.toOpt("z1"), true));
			sm.addToStates(z1);
// 6. Events 			
			Event e0, e1;
			e0 = Event.createFresh("0");
			e1 = Event.createFresh("1");
			
//			e0 = this.createAndExecuteCommand(new Event_constructor_Command("0"));
//			e1 = this.createAndExecuteCommand(new Event_constructor_Command("1"));
			
			sm.addToEvents(e0);
			sm.addToEvents(e1);
//			this.createAndExecuteCommand(new StateMachine_addEvent_Command(sm, e0));
//			this.createAndExecuteCommand(new StateMachine_addEvent_Command(sm, e1));

// 7. Transitions
			this.createAndExecuteCommand(new StateMachine_addTransition_Command(sm, z0, z1, e0));
			this.createAndExecuteCommand(new StateMachine_addTransition_Command(sm, z1, z1, e1));
			
			this.controlledView.getMessage().setText("Initialisieren und Simulieren der Eingabe von Zuständen und Transitionen abgeschlossen");
		}catch(Exception e) {
			this.controlledView.getMessage().setText("Error during intialisation: " + e.getMessage());
		}
	}
	public void handleRightClick(MouseEvent e) {
		if(!SwingUtilities.isRightMouseButton(e)) return;
		DefaultMutableTreeNode node = null;
		if(this.controlledView.getJTree().getSelectionPath().getLastPathComponent() instanceof DefaultMutableTreeNode) {
			node = (DefaultMutableTreeNode)this.controlledView.getJTree().getSelectionPath().getLastPathComponent();
			if(!(node.getUserObject() instanceof StateMachine)) return;
		}
		JPopupMenu menu = new JPopupMenu("Operations: ");
		// Fake menu items
		menu.add("Add State");
		menu.add("Add Transition");
		menu.add("Remove State");
		menu.add("Remove Transition");
		menu.add("Change Start State");
		// End fake
		JMenuItem v = new JMenuItem("Validate");
		menu.add(v);
		v.addActionListener(event->this.onValidate((StateMachine)this.getSelectedUserObject()));
		menu.show(this.controlledView.getJTree(), e.getX()+30, e.getY());
	}
// Simulieren der Tree-Anzeige, siehe unten, simulateTreeDisplay();	
	public void onValidate(StateMachine sm){
		this.controlledView.getMessage().setText("");
		String input = JOptionPane.showInputDialog(controlledView, "Enter event sequence!");
		if(input==null) {
			this.controlledView.getMessage().setText("Action aborted");
			return;
		}
		Boolean b = sm.validate(input);
		if(b) this.controlledView.getMessage().setText(input + " is valid.");
		else this.controlledView.getMessage().setText(input + " is invalid.");
	}	
 	
// ================ Additional stuff ======================	
	private void createTree() {
		this.root.removeAllChildren();
		for (IStateMachine sm : service.getStateMachineCache().values()) {
			DefaultMutableTreeNode smNode = newNode(sm.getTheObject());
			this.root.add(smNode);
			this.addStateNodes(smNode, sm);
			this.addTransitionNodes(smNode, sm);
			this.addEventNodes(smNode, sm);
		}
	}
	private void addEventNodes(DefaultMutableTreeNode smNode, IStateMachine sm) {
		DefaultMutableTreeNode eventsNode = this.addCollectionRoot(smNode, "Events");
		for (Event e: sm.getEvents()) eventsNode.add(newNode(e.getLabel()));
	}
	private void addStateNodes(DefaultMutableTreeNode smNode, IStateMachine sm) {
		DefaultMutableTreeNode statesNode = this.addCollectionRoot(smNode, "States");
		for (State s: sm.getStates()) statesNode.add(newNode(s.getName().get()));
	}
	private void addTransitionNodes(DefaultMutableTreeNode smNode, IStateMachine sm) {
		DefaultMutableTreeNode transitionNode = this.addCollectionRoot(smNode, "Transitions");
		for (Transition t: sm.getTransitions()) {
			DefaultMutableTreeNode tNode = newNode(t.toString());
			transitionNode.add(tNode);
			tNode.add(new DefaultMutableTreeNode(t.getFrom().getName().get()));
			tNode.add(new DefaultMutableTreeNode(t.getEvent().getLabel()));
			tNode.add(new DefaultMutableTreeNode(t.getTo().getName().get()));
		}
	}
	private DefaultMutableTreeNode addCollectionRoot(DefaultMutableTreeNode parent, String text) {
		DefaultMutableTreeNode collectionNode = newNode(text);
		parent.add(collectionNode);
		return collectionNode;
	}
	private Object getSelectedUserObject() {
		return ((DefaultMutableTreeNode)this.controlledView.getJTree().getSelectionPath().getLastPathComponent()).getUserObject();
	}	
	private DefaultMutableTreeNode newNode(Object o) {
		return new DefaultMutableTreeNode(o);
	}
	private <T> Optional<T> toOpt(T x){
		return Optional.of(x);
	}
	private void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {// Use standard L&F
		}
	}

}
