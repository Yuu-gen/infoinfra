/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.commands;
import generated.fileServiceWithContainment.*;
import commands.*;
public class Container_constructor_Command extends ServiceCommand<Container>{
   private static final long serialVersionUID = -937334153L;
   public Container_constructor_Command(){
      super();
   }
   public void execute(){
      try{this.result = Container.createFresh();
      }catch(Exception e){this.e = e;
      }finally{FileServiceWithContainment.getInstance().notifyObservers(this);}
   }
}
