/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.fileService.Directory;
import java.sql.ResultSet;
import java.util.Optional;
import generated.fileService.Element;
import java.util.List;
import exceptions.ConstraintViolation;
import generated.fileService.CycleException;
public class DirectoryProxy extends ElementProxy implements IDirectory{
   private Integer id;
   private Optional<Directory> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public DirectoryProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public DirectoryProxy(Directory theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Directory getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Directory";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IDirectory)) return false;
      return ((IDirectory)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Directory load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Element", this.id);
         Optional<String> name = rs.get().getObject("name") == null ? Optional.empty() : Optional.of(rs.get().getString("name"));
         return Directory.createAlreadyPersistent(this, name);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public List<Element> getElements() throws PersistenceException{
      return this.getTheObject().getElements();
   }
   public void addToElements(Element arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToElements(arg);
   }
   public boolean removeFromElements(Element arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromElements(arg);
   }
   public void addElement(Element element)throws CycleException{
      this.getTheObject().addElement(element);
   }
   public Boolean contains(Element element){
      return this.getTheObject().contains(element);
   }
}
