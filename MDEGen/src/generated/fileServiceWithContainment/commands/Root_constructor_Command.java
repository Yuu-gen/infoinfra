/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.commands;
import generated.fileServiceWithContainment.*;
import commands.*;
public class Root_constructor_Command extends ServiceCommand<Root>{
   private static final long serialVersionUID = 1037544202L;
   private Container container;
   public Root_constructor_Command(Container container){
      super();
      this.container = container;
   }
   public void execute(){
      try{this.result = Root.createFresh(container);
      }catch(Exception e){this.e = e;
      }finally{FileServiceWithContainment.getInstance().notifyObservers(this);}
   }
}
