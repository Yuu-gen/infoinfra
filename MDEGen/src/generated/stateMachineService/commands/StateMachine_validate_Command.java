/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_validate_Command extends ObjectCommand<StateMachine, Boolean>{
   private static final long serialVersionUID = 534637914L;
   private String w;
   public StateMachine_validate_Command(StateMachine receiver, String w){
      super(receiver);
      this.w = w;
   }
   public void execute(){
      try{this.result = this.receiver.validate(w);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
