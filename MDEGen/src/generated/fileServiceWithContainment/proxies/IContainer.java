/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.fileServiceWithContainment.Container;
import generated.fileServiceWithContainment.Containee;
import java.util.Set;
import exceptions.ConstraintViolation;
public interface IContainer extends Identifiable{
   public Container getTheObject();
   public Integer getId();
   public Set<Containee> getContents() throws PersistenceException;
   public void addToContents(Containee arg) throws ConstraintViolation, PersistenceException;
   public boolean removeFromContents(Containee arg) throws ConstraintViolation, PersistenceException;
}
