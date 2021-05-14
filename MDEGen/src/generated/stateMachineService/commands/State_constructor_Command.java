/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
import java.util.Optional;
public class State_constructor_Command extends ServiceCommand<State>{
   private static final long serialVersionUID = -1056130638L;
   private Optional<String>  name;
   private Boolean  isFinal;
   public State_constructor_Command(Optional<String>  name, Boolean  isFinal){
      super();
      this.name = name;
      this.isFinal = isFinal;
   }
   public void execute(){
      try{this.result = State.createFresh(name, isFinal);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
