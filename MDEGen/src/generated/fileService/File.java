/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.fileService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceExecuterFactory;
import generated.fileService.proxies.FileProxy;
import generated.fileService.proxies.IFile;
import java.util.Optional;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class File extends Element implements java.io.Serializable, IFile
{
   //30 ===== GENERATED:      Attribute Section ======
   private baseTypes.Rational size;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private File(Integer id, Optional<String> name, baseTypes.Rational size, boolean objectOnly)
   throws ConstraintViolation, PersistenceException{
      super(id, name, objectOnly);
      this.size = size;
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static File createAlreadyPersistent(FileProxy proxy, Optional<String> name, baseTypes.Rational size)throws ConstraintViolation, PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new File(proxy.getId(), name, size, true);
   }
   public static File createFresh(Optional<String> name, baseTypes.Rational size)throws ConstraintViolation, PersistenceException{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Element", "id, typeKey, name, size", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("FileService", "File").toString() + ", " + (name.isPresent() ? "'" + name.get() + "'": "NULL") + ", " + "'" + size.toString() + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      File me = new File(id, name, size, false);
      FileService.getInstance().addFileProxy(new FileProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public File getTheObject(){
      return this;
   }
   public baseTypes.Rational getSize() {
      return this.size;
   }
   public void setSize(baseTypes.Rational newSize) throws PersistenceException{
      this.size = newSize;
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Element", "size", "'" + newSize.toString() + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
/**
 * Prueft, ob element direkt oder indirekt in this enthalten ist oder ob element==this ist
 */
   public Boolean contains(Element element){
      // TODO: Implement Operation contains
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
