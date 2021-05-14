/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.fileService.relationControl;
//10 ===== GENERATED:      Import Section =========
import relationManagement.Relation;
import db.executer.PersistenceException;
import generated.fileService.proxies.*;
import exceptions.ConstraintViolation;
import java.util.List;
import java.util.Optional;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Dir_Has_ElementsSupervisor
{
   //30 ===== GENERATED:      Attribute Section ======
   private static Dir_Has_ElementsSupervisor theInstance = new Dir_Has_ElementsSupervisor();
   private Relation<IDirectory,IElement> elements;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Dir_Has_ElementsSupervisor(){
      this.elements = new Relation<>("Dir_Has_Elements");
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public static Dir_Has_ElementsSupervisor getInstance(){return theInstance;}
   public List<IElement> getElements(IDirectory owner){
      return this.elements.getRelatedTargets(owner);
   }
   public void add(IDirectory owner, IElement target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElement(owner,target);
   }
   public void addAlreadyPersistent(IDirectory owner, IElement target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, target);
      this.elements.addElementAlreadyPersistent(owner,target);
   }
   public boolean remove(IDirectory owner, IElement target) throws ConstraintViolation, PersistenceException{
      this.elements.willViolateInjectivity(owner, null);
      return this.elements.removeElement(owner,target);
   }
   public Optional<IDirectory> getContainer(IElement target){
      if(this.elements.getRelatedSources(target).size()==0) return Optional.empty(); return Optional.of(this.elements.getRelatedSources(target).get(0));
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
