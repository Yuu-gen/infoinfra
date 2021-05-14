/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.stateMachineService.State;
import java.util.Optional;
public interface IState extends Identifiable{
   public State getTheObject();
   public Integer getId();
   public Optional<String> getName() ;
   public void setName(String newName) throws PersistenceException;
   public Boolean getIsFinal() ;
   public void setIsFinal(Boolean newIsFinal) throws PersistenceException;
}
