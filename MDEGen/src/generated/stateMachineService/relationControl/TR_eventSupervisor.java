/**--- Generated at Fri May 14 10:21:49 CEST 2021 
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
public class TR_eventSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static TR_eventSupervisor theInstance = new TR_eventSupervisor();
   private Relation<ITransition,IEvent> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private TR_eventSupervisor(){
      this.elements = new Relation<>("TR_event");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static TR_eventSupervisor getInstance(){return theInstance;}
   public IEvent getEvent(ITransition owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(ITransition owner, IEvent target) throws PersistenceException{
      IEvent targetOld = this.getEvent(owner); IEvent targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(ITransition owner, IEvent target) {
      IEvent targetOld = null; IEvent targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(ITransition owner, IEvent targetOld, IEvent targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
