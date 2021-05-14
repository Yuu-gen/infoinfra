/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import db.executer.PersistenceException;
import java.util.Optional;
import db.executer.*;
import generated.fileServiceWithContainment.Root;
import java.sql.ResultSet;
import java.util.Optional;
import generated.fileServiceWithContainment.Container;
import generated.fileServiceWithContainment.relationControl.RootToCerSupervisor;
public class RootProxy implements IRoot{
   private Integer id;
   private Optional<Root> theObject;
   private PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   public RootProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public RootProxy(Root theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Root getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Root";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IRoot)) return false;
      return ((IRoot)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Root load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Root", this.id);
         Container container = RootToCerSupervisor.getInstance().getContainer(this).getTheObject();
         return Root.createAlreadyPersistent(this, container);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Container getContainer() throws PersistenceException{
      return this.getTheObject().getContainer();
   }
   public void setContainer(Container newContainer)throws PersistenceException{
      this.getTheObject().setContainer(newContainer);
   }
}
