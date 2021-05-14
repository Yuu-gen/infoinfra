/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.fileServiceWithContainment.File;
import java.sql.ResultSet;
import java.util.Optional;
import generated.fileServiceWithContainment.Container;
import generated.fileServiceWithContainment.relationControl.CerToCeeSupervisor;
public class FileProxy extends ContaineeProxy implements IFile{
   private Integer id;
   private Optional<File> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public FileProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public FileProxy(File theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public File getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "File";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IFile)) return false;
      return ((IFile)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private File load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Containee", this.id);
         Container containedIn = CerToCeeSupervisor.getInstance().getContainedIn(this).getTheObject();
         return File.createAlreadyPersistent(this, containedIn);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
}
