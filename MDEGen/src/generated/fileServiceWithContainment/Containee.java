/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.fileServiceWithContainment;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import db.connection.NoConnectionException;
import db.executer.PersistenceExecuterFactory;
import observation.Observable;
import generated.fileServiceWithContainment.proxies.IContainee;
import generated.fileServiceWithContainment.relationControl.*;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public abstract class Containee extends Observable implements java.io.Serializable, IContainee
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   public Containee(Integer id, Container containedIn, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      if(objectOnly) return;
      try{CerToCeeSupervisor.getInstance().add(containedIn,this);}catch(ConstraintViolation cv){}// Ok, because consistency is guaranteed with this statement
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Containee getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IContainee)) return false;
      return ((IContainee)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Container getContainedIn() throws PersistenceException{
      return CerToCeeSupervisor.getInstance().getContainedIn(this).getTheObject();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
