/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.fileServiceWithContainment.Directory;
import java.sql.ResultSet;
import java.util.Optional;
import generated.fileServiceWithContainment.Container;
import generated.fileServiceWithContainment.relationControl.DirToCerSupervisor;
import generated.fileServiceWithContainment.relationControl.CerToCeeSupervisor;
public class DirectoryProxy extends ContaineeProxy implements IDirectory{
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
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Containee", this.id);
         Container container = DirToCerSupervisor.getInstance().getContainer(this).getTheObject();
         Container containedIn = CerToCeeSupervisor.getInstance().getContainedIn(this).getTheObject();
         return Directory.createAlreadyPersistent(this, container, containedIn);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Container getContainer() throws PersistenceException{
      return this.getTheObject().getContainer();
   }
   public void setContainer(Container newContainer)throws PersistenceException{
      this.getTheObject().setContainer(newContainer);
   }
}
