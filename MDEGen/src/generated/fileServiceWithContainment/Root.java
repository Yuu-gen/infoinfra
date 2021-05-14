/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.fileServiceWithContainment;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceExecuterFactory;
import generated.fileServiceWithContainment.proxies.RootProxy;
import observation.Observable;
import generated.fileServiceWithContainment.proxies.IRoot;
import generated.fileServiceWithContainment.relationControl.*;
import generated.fileServiceWithContainment.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Root extends Observable implements java.io.Serializable, IRoot
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Root(Integer id, Container container, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      RootToCerSupervisor.getInstance().set(this, container);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Root createAlreadyPersistent(RootProxy proxy, Container container)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Root(proxy.getId(), container, true);
   }
   public static Root createFresh(Container container)throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Root", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("FileServiceWithContainment", "Root").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Root me = new Root(id, container, false);
      FileServiceWithContainment.getInstance().addRootProxy(new RootProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Root getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRoot)) return false;
      return ((IRoot)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Container getContainer() throws PersistenceException{
      return RootToCerSupervisor.getInstance().getContainer(this).getTheObject();
   }
   public void setContainer(Container newContainer)throws PersistenceException{
      RootToCerSupervisor.getInstance().change(this, this.getContainer(), newContainer);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
