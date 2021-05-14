/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.commands;
import generated.fileService.*;
import commands.*;
public class Element_contains_Command extends ObjectCommand<Element, Boolean>{
   private static final long serialVersionUID = 624430961L;
   private Element element;
   public Element_contains_Command(Element receiver, Element element){
      super(receiver);
      this.element = element;
   }
   public void execute(){
      try{this.result = this.receiver.contains(element);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
