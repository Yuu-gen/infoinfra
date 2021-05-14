/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class Transition_constructor_Command extends ServiceCommand<Transition>{
   private static final long serialVersionUID = 441772063L;
   private State from;
   private State to;
   private Event event;
   private StateMachine  myStateMachine;
   public Transition_constructor_Command(State from, State to, Event event, StateMachine  myStateMachine){
      super();
      this.from = from;
      this.to = to;
      this.event = event;
      this.myStateMachine = myStateMachine;
   }
   public void execute(){
      try{this.result = Transition.createFresh(from, to, event, myStateMachine);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
