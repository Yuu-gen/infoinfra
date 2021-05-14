/**--- Generated at Fri May 07 10:26:21 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.fileService;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.fileService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.fileService.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceDMLExecuter;
import db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class FileService extends Observable{
   PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,DirectoryProxy> directoryCache;
   private Map<Integer,FileProxy> fileCache;
   private static FileService theInstance = new FileService();
   private FileService(){
      try{
         PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().initializeFor("FileService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static FileService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.directoryCache = new InitialProxyLoader<DirectoryProxy>("generated", "FileService", "fileService", "Directory", "Element").perform();
      this.fileCache = new InitialProxyLoader<FileProxy>("generated", "FileService", "fileService", "File", "Element").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("Dir_Has_Elements").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Element", "FileService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Element", "FileService");
         try{this.addDir_Has_ElementsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addDir_Has_ElementsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IDirectory proxy1 = null; IElement proxy2 = null; 
      if(className1.equals("Directory"))  proxy1 = this.directoryCache.get(id1);
      if(className2.equals("Directory"))  proxy2 = this.directoryCache.get(id2);
      if(className2.equals("File"))  proxy2 = this.fileCache.get(id2);
      Dir_Has_ElementsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   public Directory getDirectory(Integer id){
      return this.directoryCache.get(id).getTheObject();
   }
   public void addDirectoryProxy(DirectoryProxy p) throws PersistenceException{
      this.directoryCache.put(p.getId(), p);
   }
   public Map<Integer,DirectoryProxy> getDirectoryCache(){
      return this.directoryCache;
   }
   public File getFile(Integer id){
      return this.fileCache.get(id).getTheObject();
   }
   public void addFileProxy(FileProxy p) throws PersistenceException{
      this.fileCache.put(p.getId(), p);
   }
   public Map<Integer,FileProxy> getFileCache(){
      return this.fileCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().closeConnection();
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
