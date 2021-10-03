package stateMachineServiceView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StateMachineServiceView extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTree jTree;
	private Controller c;
	private JTextField message;
	private JButton btnInitialise;

	/**
	 * Create the frame.
	 */
	public StateMachineServiceView(Controller c) {
		this.c = c;
		this.setVisible(true);
		setTitle("Validation of Event Sequences!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 501, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(5, 46, 481, 207);
		contentPane.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.getJTree());
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panelRight = new JPanel();
		splitPane.setRightComponent(panelRight);
		
		JLabel someText = new JLabel("Attribute Values here");
		panelRight.add(someText);
		
		JPanel panel_North = new JPanel();
		panel_North.setBounds(5, 5, 481, 41);
		contentPane.add(panel_North);
		panel_North.setLayout(null);
		
		panel_North.add(this.getBtnInitialise());
		
		
		contentPane.add(this.getMessage());
		contentPane.repaint();
	}
	public JTextField getMessage() {
		if(this.message==null) {
			message = new JTextField();
			message.setEditable(false);
			message.setBounds(5, 256, 481, 41);
			message.setColumns(10);
		}
		return this.message;
	}
	
	public JButton getBtnInitialise() {
		if(this.btnInitialise == null) {
			this.btnInitialise = new JButton("Initialise");
			this.btnInitialise.setBounds(131, 10, 139, 21);
		}
		return this.btnInitialise;
	}
	public JTree getJTree() {
		if(this.jTree==null) {
			this.jTree = new JTree();
		}
		return this.jTree;
	}
}
