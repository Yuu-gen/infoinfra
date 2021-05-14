/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- No Change Allowed!  
 */
package generated.fileService.commands;
import generated.fileService.*;
import commands.*;
import java.util.Optional;
public class File_constructor_Command extends ServiceCommand<File>{
   private static final long serialVersionUID = 1401161984L;
   private Optional<String>  name;
   private baseTypes.Rational  size;
   public File_constructor_Command(Optional<String>  name, baseTypes.Rational  size){
      super();
      this.name = name;
      this.size = size;
   }
   public void execute(){
      try{this.result = File.createFresh(name, size);
      }catch(Exception e){this.e = e;
      }finally{FileService.getInstance().notifyObservers(this);}
   }
}
