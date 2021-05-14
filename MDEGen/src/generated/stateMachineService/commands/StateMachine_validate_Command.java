/**--- Generated at Fri May 07 15:53:48 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_validate_Command extends ObjectCommand<StateMachine, Boolean>{
   private static final long serialVersionUID = 1940536248L;
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
