/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.stateMachineService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.stateMachineService.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class TR_toSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static TR_toSupervisor theInstance = new TR_toSupervisor();
   private Relation<ITransition,IState> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private TR_toSupervisor(){
      this.elements = new Relation<>("TR_to");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static TR_toSupervisor getInstance(){return theInstance;}
   public IState getTo(ITransition owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ITransition owner, IState target) throws PersistenceException{
      IState targetOld = this.getTo(owner); IState targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(ITransition owner, IState target) {
      IState targetOld = null; IState targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ITransition owner, IState targetOld, IState targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
