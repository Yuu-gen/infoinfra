/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.commands;
import generated.fileServiceWithContainment.*;
import commands.*;
public class Directory_constructor_Command extends ServiceCommand<Directory>{
   private static final long serialVersionUID = -1670528643L;
   private Container container;
   private Container containedIn;
   public Directory_constructor_Command(Container container, Container containedIn){
      super();
      this.container = container;
      this.containedIn = containedIn;
   }
   public void execute(){
      try{this.result = Directory.createFresh(container, containedIn);
      }catch(Exception e){this.e = e;
      }finally{FileServiceWithContainment.getInstance().notifyObservers(this);}
   }
}
