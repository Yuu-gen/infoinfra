/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.fileService.File;
import java.sql.ResultSet;
import java.util.Optional;
import generated.fileService.Element;
public class FileProxy extends ElementProxy implements IFile{
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
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Element", this.id);
         Optional<String> name = rs.get().getObject("name") == null ? Optional.empty() : Optional.of(rs.get().getString("name"));
         baseTypes.Rational size = new baseTypes.Rational(rs.get().getString("size"));
         return File.createAlreadyPersistent(this, name, size);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public baseTypes.Rational getSize() {
      return this.getTheObject().getSize();
   }
   public void setSize(baseTypes.Rational newSize) throws PersistenceException{
      this.getTheObject().setSize(newSize);
   }
   public Boolean contains(Element element){
      return this.getTheObject().contains(element);
   }
}
