/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.commands;
import generated.fileService.*;
import commands.*;
public class Directory_addElement_Command extends ObjectCommand<Directory, Void>{
   private static final long serialVersionUID = -1624812428L;
   private Element element;
   public Directory_addElement_Command(Directory receiver, Element element){
      super(receiver);
      this.element = element;
   }
   public void execute(){
      try{this.receiver.addElement(element);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
