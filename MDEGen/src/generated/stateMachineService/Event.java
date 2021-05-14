/**--- Generated at Fri May 14 10:30:26 CEST 2021 
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
import generated.stateMachineService.proxies.EventProxy;
import observation.Observable;
import generated.stateMachineService.proxies.IEvent;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Event extends Observable implements java.io.Serializable, IEvent
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String label;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Event(Integer id, String label, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.label = label;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Event createAlreadyPersistent(EventProxy proxy, String label){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Event(proxy.getId(), label, true);
   }
   public static Event createFresh(String label)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Event", "id, typeKey, label", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "Event").toString() + ", " + "'" + label + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Event me = new Event(id, label, false);
      StateMachineService.getInstance().addEventProxy(new EventProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Event getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IEvent)) return false;
      return ((IEvent)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getLabel() {
      return this.label;
   }
   public void setLabel(String newLabel) throws PersistenceException{
      this.label = newLabel;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Event", "label", "'" + newLabel + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
