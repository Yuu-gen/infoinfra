/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_changeStartState_Command extends ObjectCommand<StateMachine, Void>{
   private static final long serialVersionUID = -1805326027L;
   private State z0;
   public StateMachine_changeStartState_Command(StateMachine receiver, State z0){
      super(receiver);
      this.z0 = z0;
   }
   public void execute(){
      try{this.receiver.changeStartState(z0);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
