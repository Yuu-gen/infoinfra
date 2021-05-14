/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.fileService.File;
import java.util.Optional;
import generated.fileService.Element;
public interface IFile extends IElement{
   public File getTheObject();
   public Integer getId();
   public baseTypes.Rational getSize() ;
   public void setSize(baseTypes.Rational newSize) throws PersistenceException;
   public Boolean contains(Element element);
}
