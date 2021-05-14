/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.proxies;
import db.executer.PersistenceException;
import generated.fileService.Element;
import java.util.Optional;
import generated.fileService.Directory;
public abstract class ElementProxy implements IElement{
   public abstract Element getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof IElement)) return false;
      return ((IElement)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Optional<String> getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public Optional<Directory> getContainer() throws PersistenceException{
      return this.getTheObject().getContainer();
   }
   public abstract Boolean contains(Element element);
}
