/**--- Generated at Fri May 14 10:21:48 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.stateMachineService.Event;
public interface IEvent extends Identifiable{
   public Event getTheObject();
   public Integer getId();
   public String getLabel() ;
   public void setLabel(String newLabel) throws PersistenceException;
}
