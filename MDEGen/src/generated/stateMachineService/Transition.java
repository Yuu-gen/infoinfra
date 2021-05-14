/**--- Generated at Fri May 14 10:21:48 CEST 2021 
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
import generated.stateMachineService.proxies.TransitionProxy;
import observation.Observable;
import generated.stateMachineService.proxies.ITransition;
import generated.stateMachineService.relationControl.*;
import generated.stateMachineService.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Transition extends Observable implements java.io.Serializable, ITransition
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Transition(Integer id, State from, State to, Event event, StateMachine myStateMachine, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      TR_fromSupervisor.getInstance().set(this, from);
      TR_toSupervisor.getInstance().set(this, to);
      TR_eventSupervisor.getInstance().set(this, event);
      if(objectOnly) return;
      try{SM_TransitionsSupervisor.getInstance().add(myStateMachine,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Transition createAlreadyPersistent(TransitionProxy proxy, State from, State to, Event event, StateMachine myStateMachine)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Transition(proxy.getId(), from, to, event, myStateMachine, true);
   }
   public static Transition createFresh(State from, State to, Event event, StateMachine myStateMachine)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Transition", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "Transition").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Transition me = new Transition(id, from, to, event, myStateMachine, false);
      StateMachineService.getInstance().addTransitionProxy(new TransitionProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Transition getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof ITransition)) return false;
      return ((ITransition)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public State getFrom() throws PersistenceException{
      return TR_fromSupervisor.getInstance().getFrom(this).getTheObject();
   }
   public void setFrom(State newFrom)throws PersistenceException{
      TR_fromSupervisor.getInstance().change(this, this.getFrom(), newFrom);
   }
   public State getTo() throws PersistenceException{
      return TR_toSupervisor.getInstance().getTo(this).getTheObject();
   }
   public void setTo(State newTo)throws PersistenceException{
      TR_toSupervisor.getInstance().change(this, this.getTo(), newTo);
   }
   public Event getEvent() throws PersistenceException{
      return TR_eventSupervisor.getInstance().getEvent(this).getTheObject();
   }
   public void setEvent(Event newEvent)throws PersistenceException{
      TR_eventSupervisor.getInstance().change(this, this.getEvent(), newEvent);
   }
   public StateMachine getMyStateMachine() throws PersistenceException{
      return SM_TransitionsSupervisor.getInstance().getMyStateMachine(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
