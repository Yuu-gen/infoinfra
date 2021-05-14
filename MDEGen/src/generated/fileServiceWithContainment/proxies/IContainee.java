/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.fileServiceWithContainment.Containee;
import generated.fileServiceWithContainment.Container;
public interface IContainee extends Identifiable{
   public Containee getTheObject();
   public Container getContainedIn() throws PersistenceException;
}
