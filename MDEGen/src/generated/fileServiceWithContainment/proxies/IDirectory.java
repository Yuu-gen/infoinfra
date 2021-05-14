/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.fileServiceWithContainment.Directory;
import generated.fileServiceWithContainment.Container;
public interface IDirectory extends IContainee{
   public Directory getTheObject();
   public Integer getId();
   public Container getContainer() throws PersistenceException;
   public void setContainer(Container newContainer)throws PersistenceException;
}
