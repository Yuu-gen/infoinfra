/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.stateMachineService.StateMachine;
import java.sql.ResultSet;
import java.util.Optional;
import generated.stateMachineService.State;
import generated.stateMachineService.relationControl.SM_StartStateSupervisor;
import java.util.Set;
import generated.stateMachineService.Transition;
import exceptions.ConstraintViolation;
import generated.stateMachineService.Event;
public class StateMachineProxy implements IStateMachine{
   private Integer id;
   private Optional<StateMachine> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public StateMachineProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public StateMachineProxy(StateMachine theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public StateMachine getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "StateMachine";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IStateMachine)) return false;
      return ((IStateMachine)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private StateMachine load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("StateMachine", this.id);
         State startState = SM_StartStateSupervisor.getInstance().getStartState(this).getTheObject();
         String name = rs.get().getString("name");
         return StateMachine.createAlreadyPersistent(this, startState, name);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public State getStartState() throws PersistenceException{
      return this.getTheObject().getStartState();
   }
   public void setStartState(State newStartState)throws PersistenceException{
      this.getTheObject().setStartState(newStartState);
   }
   public Set<State> getStates() throws PersistenceException{
      return this.getTheObject().getStates();
   }
   public void addToStates(State arg) throws PersistenceException{
      this.getTheObject().addToStates(arg);
   }
   public boolean removeFromStates(State arg) throws PersistenceException{
      return this.getTheObject().removeFromStates(arg);
   }
   public Set<Transition> getTransitions() throws PersistenceException{
      return this.getTheObject().getTransitions();
   }
   public void addToTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToTransitions(arg);
   }
   public boolean removeFromTransitions(Transition arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromTransitions(arg);
   }
   public Set<Event> getEvents() throws PersistenceException{
      return this.getTheObject().getEvents();
   }
   public void addToEvents(Event arg) throws PersistenceException{
      this.getTheObject().addToEvents(arg);
   }
   public boolean removeFromEvents(Event arg) throws PersistenceException{
      return this.getTheObject().removeFromEvents(arg);
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public void changeStartState(State z0){
      this.getTheObject().changeStartState(z0);
   }
   public void addState(String name, Boolean isFinal){
      this.getTheObject().addState(name, isFinal);
   }
   public Boolean validate(String w){
      return this.getTheObject().validate(w);
   }
   public void addTransition(State from, State to, Event event){
      this.getTheObject().addTransition(from, to, event);
   }
}
