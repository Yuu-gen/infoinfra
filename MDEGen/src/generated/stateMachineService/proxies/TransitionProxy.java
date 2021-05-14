/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.stateMachineService.Transition;
import java.sql.ResultSet;
import java.util.Optional;
import generated.stateMachineService.State;
import generated.stateMachineService.relationControl.TR_fromSupervisor;
import generated.stateMachineService.relationControl.TR_toSupervisor;
import generated.stateMachineService.Event;
import generated.stateMachineService.relationControl.TR_eventSupervisor;
import generated.stateMachineService.StateMachine;
import generated.stateMachineService.relationControl.SM_TransitionsSupervisor;
public class TransitionProxy implements ITransition{
   private Integer id;
   private Optional<Transition> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public TransitionProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public TransitionProxy(Transition theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Transition getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Transition";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ITransition)) return false;
      return ((ITransition)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Transition load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Transition", this.id);
         State from = TR_fromSupervisor.getInstance().getFrom(this).getTheObject();
         State to = TR_toSupervisor.getInstance().getTo(this).getTheObject();
         Event event = TR_eventSupervisor.getInstance().getEvent(this).getTheObject();
         StateMachine myStateMachine = SM_TransitionsSupervisor.getInstance().getMyStateMachine(this).getTheObject();
         return Transition.createAlreadyPersistent(this, from, to, event, myStateMachine);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public State getFrom() throws PersistenceException{
      return this.getTheObject().getFrom();
   }
   public void setFrom(State newFrom)throws PersistenceException{
      this.getTheObject().setFrom(newFrom);
   }
   public State getTo() throws PersistenceException{
      return this.getTheObject().getTo();
   }
   public void setTo(State newTo)throws PersistenceException{
      this.getTheObject().setTo(newTo);
   }
   public Event getEvent() throws PersistenceException{
      return this.getTheObject().getEvent();
   }
   public void setEvent(Event newEvent)throws PersistenceException{
      this.getTheObject().setEvent(newEvent);
   }
   public StateMachine getMyStateMachine() throws PersistenceException{
      return this.getTheObject().getMyStateMachine();
   }
}
