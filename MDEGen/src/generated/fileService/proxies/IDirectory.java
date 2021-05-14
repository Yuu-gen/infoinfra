/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.fileService.Directory;
import generated.fileService.Element;
import java.util.List;
import exceptions.ConstraintViolation;
import java.util.Optional;
import generated.fileService.CycleException;
public interface IDirectory extends IElement{
   public Directory getTheObject();
   public Integer getId();
   public List<Element> getElements() throws PersistenceException;
   public void addToElements(Element arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromElements(Element arg) throws ConstraintViolation, PersistenceException;
   public void addElement(Element element)throws CycleException;
   public Boolean contains(Element element);
}
