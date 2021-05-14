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
import generated.fileServiceWithContainment.proxies.DirectoryProxy;
import generated.fileServiceWithContainment.proxies.IDirectory;
import generated.fileServiceWithContainment.relationControl.*;
import generated.fileServiceWithContainment.proxies.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Directory extends Containee implements java.io.Serializable, IDirectory
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Directory(Integer id, Container container, Container containedIn, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, containedIn, objectOnly);
      DirToCerSupervisor.getInstance().set(this, container);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Directory createAlreadyPersistent(DirectoryProxy proxy, Container container, Container containedIn)throws PersistenceException, ConstraintViolation{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Directory(proxy.getId(), container, containedIn, true);
   }
   public static Directory createFresh(Container container, Container containedIn)throws PersistenceException, ConstraintViolation{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Containee", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("FileServiceWithContainment", "Directory").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Directory me = new Directory(id, container, containedIn, false);
      FileServiceWithContainment.getInstance().addDirectoryProxy(new DirectoryProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Directory getTheObject(){
      return this;
   }
   public Container getContainer() throws PersistenceException{
      return DirToCerSupervisor.getInstance().getContainer(this).getTheObject();
   }
   public void setContainer(Container newContainer)throws PersistenceException{
      DirToCerSupervisor.getInstance().change(this, this.getContainer(), newContainer);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
