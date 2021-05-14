/**--- Generated at Fri May 14 10:21:48 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class Event_constructor_Command extends ServiceCommand<Event>{
   private static final long serialVersionUID = 274745357L;
   private String  label;
   public Event_constructor_Command(String  label){
      super();
      this.label = label;
   }
   public void execute(){
      try{this.result = Event.createFresh(label);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
