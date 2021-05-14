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
import generated.stateMachineService.proxies.StateProxy;
import observation.Observable;
import generated.stateMachineService.proxies.IState;
import java.util.Optional;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class State extends Observable implements java.io.Serializable, IState
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Optional<String> name;
   private Boolean isFinal;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private State(Integer id, Optional<String> name, Boolean isFinal, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      this.isFinal = isFinal;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static State createAlreadyPersistent(StateProxy proxy, Optional<String> name, Boolean isFinal){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new State(proxy.getId(), name, isFinal, true);
   }
   public static State createFresh(Optional<String> name, Boolean isFinal)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("State", "id, typeKey, name, isFinal", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("StateMachineService", "State").toString() + ", " + (name.isPresent() ? "'" + name.get() + "'": "NULL") + ", " + isFinal.toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      State me = new State(id, name, isFinal, false);
      StateMachineService.getInstance().addStateProxy(new StateProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public State getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IState)) return false;
      return ((IState)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<String> getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = Optional.of(newName);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("State", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Boolean getIsFinal() {
      return this.isFinal;
   }
   public void setIsFinal(Boolean newIsFinal) throws PersistenceException{
      this.isFinal = newIsFinal;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("State", "isFinal", newIsFinal.toString(), this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
