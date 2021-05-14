/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.fileServiceWithContainment.Container;
import java.sql.ResultSet;
import java.util.Optional;
import generated.fileServiceWithContainment.Containee;
import java.util.Set;
import exceptions.ConstraintViolation;
public class ContainerProxy implements IContainer{
   private Integer id;
   private Optional<Container> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public ContainerProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ContainerProxy(Container theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Container getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Container";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IContainer)) return false;
      return ((IContainer)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Container load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Container", this.id);
         return Container.createAlreadyPersistent(this);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Set<Containee> getContents() throws PersistenceException{
      return this.getTheObject().getContents();
   }
   public void addToContents(Containee arg) throws ConstraintViolation, PersistenceException{
      this.getTheObject().addToContents(arg);
   }
   public boolean removeFromContents(Containee arg) throws ConstraintViolation, PersistenceException{
      return this.getTheObject().removeFromContents(arg);
   }
}
