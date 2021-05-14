/**--- Generated at Fri May 14 10:21:48 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class initialise_Command extends ServiceCommand<StateMachine>{
   private static final long serialVersionUID = 1115884795L;
   private State startState;
   private String smName;
   public initialise_Command(State startState, String smName){
      super();
      this.startState = startState;
      this.smName = smName;
   }
   public void execute(){
      try{this.result = StateMachineService.getInstance().initialise(startState, smName);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
