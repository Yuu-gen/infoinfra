/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.fileServiceWithContainment.Root;
import generated.fileServiceWithContainment.Container;
public interface IRoot extends Identifiable{
   public Root getTheObject();
   public Integer getId();
   public Container getContainer() throws PersistenceException;
   public void setContainer(Container newContainer)throws PersistenceException;
}
