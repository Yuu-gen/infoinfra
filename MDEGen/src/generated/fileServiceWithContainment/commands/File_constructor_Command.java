/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileServiceWithContainment.commands;
import generated.fileServiceWithContainment.*;
import commands.*;
public class File_constructor_Command extends ServiceCommand<File>{
   private static final long serialVersionUID = -908618158L;
   private Container containedIn;
   public File_constructor_Command(Container containedIn){
      super();
      this.containedIn = containedIn;
   }
   public void execute(){
      try{this.result = File.createFresh(containedIn);
      }catch(Exception e){this.e = e;
      }finally{FileServiceWithContainment.getInstance().notifyObservers(this);}
   }
}
