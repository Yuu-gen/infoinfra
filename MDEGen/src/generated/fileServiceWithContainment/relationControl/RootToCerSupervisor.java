/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.fileServiceWithContainment.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.fileServiceWithContainment.proxies.*;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class RootToCerSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static RootToCerSupervisor theInstance = new RootToCerSupervisor();
   private Relation<IRoot,IContainer> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private RootToCerSupervisor(){
      this.elements = new Relation<>("RootToCer");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static RootToCerSupervisor getInstance(){return theInstance;}
   public IContainer getContainer(IRoot owner){
      return this.elements.getRelatedTargets(owner).isEmpty() ? null : this.elements.getRelatedTargets(owner).get(0);
   }
   public void set(IRoot owner, IContainer target) throws PersistenceException{
      IContainer targetOld = this.getContainer(owner); IContainer targetNew = target;
      this.elements.change(owner, targetOld, targetNew);
   }
   public void setAlreadyPersistent(IRoot owner, IContainer target) {
      IContainer targetOld = null; IContainer targetNew = target;
      this.elements.setAlreadyPersistent(owner, targetNew);
   }
   public void change(IRoot owner, IContainer targetOld, IContainer targetNew) throws PersistenceException{
      this.elements.change(owner, targetOld, targetNew);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
