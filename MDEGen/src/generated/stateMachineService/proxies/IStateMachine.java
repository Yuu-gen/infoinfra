/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.stateMachineService.StateMachine;
import generated.stateMachineService.State;
import java.util.Set;
import generated.stateMachineService.Transition;
import exceptions.ConstraintViolation;
import generated.stateMachineService.Event;
public interface IStateMachine extends Identifiable{
   public StateMachine getTheObject();
   public Integer getId();
   public State getStartState() throws PersistenceException;
   public void setStartState(State newStartState)throws PersistenceException;
   public Set<State> getStates() throws PersistenceException;
   public void addToStates(State arg) throws PersistenceException;
   public boolean removeFromStates(State arg) throws PersistenceException;
   public Set<Transition> getTransitions() throws PersistenceException;
   public void addToTransitions(Transition arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromTransitions(Transition arg) throws ConstraintViolation, PersistenceException;
   public Set<Event> getEvents() throws PersistenceException;
   public void addToEvents(Event arg) throws PersistenceException;
   public boolean removeFromEvents(Event arg) throws PersistenceException;
   public String getName() ;
   public void setName(String newName) throws PersistenceException;
   public void changeStartState(State z0);
   public void addState(String name, Boolean isFinal);
   public Boolean validate(String w);
   public void addTransition(State from, State to, Event event);
}
