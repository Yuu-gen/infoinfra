/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.proxies;
import db.executer.PersistenceException;
import generated.fileServiceWithContainment.Containee;
import generated.fileServiceWithContainment.Container;
public abstract class ContaineeProxy implements IContainee{
   public abstract Containee getTheObject();
   public boolean equals(Object o) {
      if(!(o instanceof IContainee)) return false;
      return ((IContainee)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Container getContainedIn() throws PersistenceException{
      return this.getTheObject().getContainedIn();
   }
}
