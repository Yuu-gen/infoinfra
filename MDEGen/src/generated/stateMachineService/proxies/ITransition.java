/**--- Generated at Fri May 14 10:21:48 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.stateMachineService.Transition;
import generated.stateMachineService.State;
import generated.stateMachineService.Event;
import generated.stateMachineService.StateMachine;
public interface ITransition extends Identifiable{
   public Transition getTheObject();
   public Integer getId();
   public State getFrom() throws PersistenceException;
   public void setFrom(State newFrom)throws PersistenceException;
   public State getTo() throws PersistenceException;
   public void setTo(State newTo)throws PersistenceException;
   public Event getEvent() throws PersistenceException;
   public void setEvent(Event newEvent)throws PersistenceException;
   public StateMachine getMyStateMachine() throws PersistenceException;
}
