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
import observation.Observable;
import generated.fileService.proxies.IElement;
import java.util.Optional;
import db.executer.PersistenceException;
import generated.fileService.relationControl.*;
import generated.fileService.proxies.IDirectory;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class Element extends Observable implements java.io.Serializable, IElement
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private Optional<String> name;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public Element(Integer id, Optional<String> name, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      if(objectOnly) return;
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Element getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IElement)) return false;
      return ((IElement)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<String> getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = Optional.of(newName);
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter().update("Element", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Optional<Directory> getContainer() throws PersistenceException{
      Optional<IDirectory> opt = Dir_Has_ElementsSupervisor.getInstance().getContainer(this);
      return opt.isPresent() ? Optional.of(Dir_Has_ElementsSupervisor.getInstance().getContainer(this).get().getTheObject()) : Optional.empty();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Prueft, ob element direkt oder indirekt in this enthalten ist oder ob element==this ist
 */
   public abstract Boolean contains(Element element);
//90 ===== GENERATED: End of Your Operations ======
}
