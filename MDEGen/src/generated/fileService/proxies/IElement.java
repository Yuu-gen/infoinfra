/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.fileService.Element;
import java.util.Optional;
import generated.fileService.Directory;
public interface IElement extends Identifiable{
   public Element getTheObject();
   public Optional<String> getName() ;
   public void setName(String newName) throws PersistenceException;
   public Optional<Directory> getContainer() throws PersistenceException;
   public abstract Boolean contains(Element element);
}
