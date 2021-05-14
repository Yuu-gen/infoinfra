/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.commands;
import generated.fileService.*;
import commands.*;
import java.util.Optional;
public class Directory_constructor_Command extends ServiceCommand<Directory>{
   private static final long serialVersionUID = 1161897264L;
   private Optional<String>  name;
   public Directory_constructor_Command(Optional<String>  name){
      super();
      this.name = name;
   }
   public void execute(){
      try{this.result = Directory.createFresh(name);
      }catch(Exception e){this.e = e;
      }finally{FileService.getInstance().notifyObservers(this);}
   }
}
