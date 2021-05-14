/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_addState_Command extends ObjectCommand<StateMachine, Void>{
   private static final long serialVersionUID = -320540416L;
   private String name;
   private Boolean isFinal;
   public StateMachine_addState_Command(StateMachine receiver, String name, Boolean isFinal){
      super(receiver);
      this.name = name;
      this.isFinal = isFinal;
   }
   public void execute(){
      try{this.receiver.addState(name, isFinal);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
