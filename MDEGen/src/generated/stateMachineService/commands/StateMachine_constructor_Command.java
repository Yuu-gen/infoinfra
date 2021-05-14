/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class StateMachine_constructor_Command extends ServiceCommand<StateMachine>{
   private static final long serialVersionUID = -522905555L;
   private State startState;
   private String  name;
   public StateMachine_constructor_Command(State startState, String  name){
      super();
      this.startState = startState;
      this.name = name;
   }
   public void execute(){
      try{this.result = StateMachine.createFresh(startState, name);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
