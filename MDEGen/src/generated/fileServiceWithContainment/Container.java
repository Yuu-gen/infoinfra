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
import generated.fileServiceWithContainment.proxies.ContainerProxy;
import observation.Observable;
import generated.fileServiceWithContainment.proxies.IContainer;
import generated.fileServiceWithContainment.relationControl.*;
import generated.fileServiceWithContainment.proxies.*;
import db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Container extends Observable implements java.io.Serializable, IContainer
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Container(Integer id, boolean objectOnly)
   {
      super();
      this.setId(id);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Container createAlreadyPersistent(ContainerProxy proxy){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Container(proxy.getId(), true);
   }
   public static Container createFresh()throws PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Container", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("FileServiceWithContainment", "Container").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Container me = new Container(id, false);
      FileServiceWithContainment.getInstance().addContainerProxy(new ContainerProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Container getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IContainer)) return false;
      return ((IContainer)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<Containee> getContents() throws PersistenceException{
      Set<Containee> result = new HashSet<>();
      for (IContainee i : CerToCeeSupervisor.getInstance().getContents(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToContents(Containee arg) throws ConstraintViolation, PersistenceException{
      CerToCeeSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromContents(Containee arg) throws ConstraintViolation, PersistenceException{
      return CerToCeeSupervisor.getInstance().remove(this, arg);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
