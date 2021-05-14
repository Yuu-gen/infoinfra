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
import generated.fileService.proxies.DirectoryProxy;
import generated.fileService.proxies.IDirectory;
import generated.fileService.relationControl.*;
import generated.fileService.proxies.*;
import db.executer.PersistenceException;
import java.util.List;
import java.util.ArrayList;
import exceptions.ConstraintViolation;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Directory extends Element implements java.io.Serializable, IDirectory
{
   //30 ===== GENERATED:      Attribute Section ======
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Directory(Integer id, Optional<String> name, boolean objectOnly)
   throws PersistenceException, ConstraintViolation{
      super(id, name, objectOnly);
      if(objectOnly) return;
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Directory createAlreadyPersistent(DirectoryProxy proxy, Optional<String> name)throws PersistenceException, ConstraintViolation{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Directory(proxy.getId(), name, true);
   }
   public static Directory createFresh(Optional<String> name)throws PersistenceException, ConstraintViolation{
      db.executer.PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Element", "id, typeKey, name", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("FileService", "Directory").toString() + ", " + (name.isPresent() ? "'" + name.get() + "'": "NULL"));
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Directory me = new Directory(id, name, false);
      FileService.getInstance().addDirectoryProxy(new DirectoryProxy(me));
      return me;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Directory getTheObject(){
      return this;
   }
   public List<Element> getElements() throws PersistenceException{
      List<Element> result = new ArrayList<>();
      for (IElement i : Dir_Has_ElementsSupervisor.getInstance().getElements(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToElements(Element arg) throws ConstraintViolation, PersistenceException{
      Dir_Has_ElementsSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromElements(Element arg) throws ConstraintViolation, PersistenceException{
      return Dir_Has_ElementsSupervisor.getInstance().remove(this, arg);
   }
   //80 ===== Editable : Your Operations =============
/**
 * Fuegt element zu this hinzu, wenn element nicht this enthält und element ungleich this ist. Im anderen Fall wird CycleException geworfen
 */
   public void addElement(Element element)throws CycleException{
      // TODO: Implement Operation addElement
      return;
   }
/**
 * Prueft, ob element direkt oder indirekt in this enthalten ist oder ob element==this ist
 */
   public Boolean contains(Element element){
      // TODO: Implement Operation contains
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
