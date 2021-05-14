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
import generated.fileServiceWithContainment.proxies.FileProxy;
import generated.fileServiceWithContainment.proxies.IFile;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class File extends Containee implements java.io.Serializable, IFile
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private File(Integer id, Container containedIn, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, containedIn, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static File createAlreadyPersistent(FileProxy proxy, Container containedIn)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new File(proxy.getId(), containedIn, true);
   }
   public static File createFresh(Container containedIn)throws ConstraintViolation, PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Containee", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("FileServiceWithContainment", "File").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      File me = new File(id, containedIn, false);
      FileServiceWithContainment.getInstance().addFileProxy(new FileProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public File getTheObject(){
      return this;
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
