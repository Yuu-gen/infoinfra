/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_addTransition_Command extends ObjectCommand<StateMachine, Void>{
   private static final long serialVersionUID = -1027782512L;
   private State from;
   private State to;
   private Event event;
   public StateMachine_addTransition_Command(StateMachine receiver, State from, State to, Event event){
      super(receiver);
      this.from = from;
      this.to = to;
      this.event = event;
   }
   public void execute(){
      try{this.receiver.addTransition(from, to, event);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
