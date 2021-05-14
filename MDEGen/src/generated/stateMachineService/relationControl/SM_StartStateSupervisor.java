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
public class SM_StartStateSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static SM_StartStateSupervisor theInstance = new SM_StartStateSupervisor();
   private Relation<IStateMachine,IState> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private SM_StartStateSupervisor(){
      this.elements = new Relation<>("SM_StartState");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static SM_StartStateSupervisor getInstance(){return theInstance;}
   public IState getStartState(IStateMachine owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IStateMachine owner, IState target) throws PersistenceException{
      IState targetOld = this.getStartState(owner); IState targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IStateMachine owner, IState target) {
      IState targetOld = null; IState targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IStateMachine owner, IState targetOld, IState targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
