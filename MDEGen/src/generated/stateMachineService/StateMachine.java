/**--- Generated at Fri May 14 10:21:49 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.stateMachineService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceExecuterFactory;
import generated.stateMachineService.proxies.StateMachineProxy;
import observation.Observable;
import generated.stateMachineService.proxies.IStateMachine;
import generated.stateMachineService.relationControl.*;
import generated.stateMachineService.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class StateMachine extends Observable implements java.io.Serializable, IStateMachine
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private StateMachine(Integer id, State startState, String name, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      SM_StartStateSupervisor.getInstance().set(this, startState);
      this.name = name;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static StateMachine createAlreadyPersistent(StateMachineProxy proxy, State startState, String name)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new StateMachine(proxy.getId(), startState, name, true);
   }
   public static StateMachine createFresh(State startState, String name)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("StateMachine", "id, typeKey, name", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "StateMachine").toString() + ", " + "'" + name + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      StateMachine me = new StateMachine(id, startState, name, false);
      StateMachineService.getInstance().addStateMachineProxy(new StateMachineProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public StateMachine getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IStateMachine)) return false;
      return ((IStateMachine)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public State getStartState() throws PersistenceException{
      return SM_StartStateSupervisor.getInstance().getStartState(this).getTheObject();
   }
   public void setStartState(State newStartState)throws PersistenceException{
      SM_StartStateSupervisor.getInstance().change(this, this.getStartState(), newStartState);
   }
   public Set<State> getStates() throws PersistenceException{
      Set<State> result = new HashSet<>();
      for (IState i : SM_StatesSupervisor.getInstance().getStates(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToStates(State arg) throws PersistenceException{
      SM_StatesSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromStates(State arg) throws PersistenceException{
      return SM_StatesSupervisor.getInstance().remove(this, arg);
   }
   public Set<Transition> getTransitions() throws PersistenceException{
      Set<Transition> result = new HashSet<>();
      for (ITransition i : SM_TransitionsSupervisor.getInstance().getTransitions(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      SM_TransitionsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      return SM_TransitionsSupervisor.getInstance().remove(this, arg);
   }
   public Set<Event> getEvents() throws PersistenceException{
      Set<Event> result = new HashSet<>();
      for (IEvent i : SM_eventsSupervisor.getInstance().getEvents(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToEvents(Event arg) throws PersistenceException{
      SM_eventsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromEvents(Event arg) throws PersistenceException{
      return SM_eventsSupervisor.getInstance().remove(this, arg);
   }
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("StateMachine", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
/**
 * Validiert ob, das Wort w von diesem Automaten erkannt wird
 */
   public Boolean validate(String w){
      // TODO: Implement Operation validate
      return null;
   }
/**
 * Fuegt eine Transition mit Zustand "for", Zustand "to" und Event "event" hinzu.
 */
   public void addTransition(State from, State to, Event event){
      // TODO: Implement Operation addTransition
      return;
   }
/**
 * Fuegt einen Zustand mit Namen name hinzu, der Endzustand ist, sofern isFinal = true.
 */
   public void addState(String name, Boolean isFinal){
      // TODO: Implement Operation addState
      return;
   }
/**
 * Aendert den Startzustand zu dem Zustand z0.
 */
   public void changeStartState(State z0){
      // TODO: Implement Operation changeStartState
      return;
   }
//90 ===== GENERATED: End of Your Operations ======
}
