/**--- Generated at Fri May 07 10:33:44 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.fileServiceWithContainment;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.fileServiceWithContainment.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.fileServiceWithContainment.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceDMLExecuter;
import db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class FileServiceWithContainment extends Observable{
   PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,ContainerProxy> containerCache;
   private Map<Integer,RootProxy> rootCache;
   private Map<Integer,DirectoryProxy> directoryCache;
   private Map<Integer,FileProxy> fileCache;
   private static FileServiceWithContainment theInstance = new FileServiceWithContainment();
   private FileServiceWithContainment(){
      try{
         PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().initializeFor("FileServiceWithContainment");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static FileServiceWithContainment getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.containerCache = new InitialProxyLoader<ContainerProxy>("generated", "FileServiceWithContainment", "fileServiceWithContainment", "Container", "Container").perform();
      this.rootCache = new InitialProxyLoader<RootProxy>("generated", "FileServiceWithContainment", "fileServiceWithContainment", "Root", "Root").perform();
      this.directoryCache = new InitialProxyLoader<DirectoryProxy>("generated", "FileServiceWithContainment", "fileServiceWithContainment", "Directory", "Containee").perform();
      this.fileCache = new InitialProxyLoader<FileProxy>("generated", "FileServiceWithContainment", "fileServiceWithContainment", "File", "Containee").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("CerToCee").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Container", "FileServiceWithContainment");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Containee", "FileServiceWithContainment");
         try{this.addCerToCeeElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("RootToCer").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Root", "FileServiceWithContainment");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Container", "FileServiceWithContainment");
         try{this.addRootToCerElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("DirToCer").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Containee", "FileServiceWithContainment");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Container", "FileServiceWithContainment");
         try{this.addDirToCerElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addCerToCeeElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IContainer proxy1 = null; IContainee proxy2 = null; 
      if(className1.equals("Container"))  proxy1 = this.containerCache.get(id1);
      if(className2.equals("Directory"))  proxy2 = this.directoryCache.get(id2);
      if(className2.equals("File"))  proxy2 = this.fileCache.get(id2);
      CerToCeeSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addRootToCerElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IRoot proxy1 = null; IContainer proxy2 = null; 
      if(className2.equals("Container"))  proxy2 = this.containerCache.get(id2);
      if(className1.equals("Root"))  proxy1 = this.rootCache.get(id1);
      RootToCerSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addDirToCerElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IDirectory proxy1 = null; IContainer proxy2 = null; 
      if(className2.equals("Container"))  proxy2 = this.containerCache.get(id2);
      if(className1.equals("Directory"))  proxy1 = this.directoryCache.get(id1);
      DirToCerSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   public Container getContainer(Integer id){
      return this.containerCache.get(id).getTheObject();
   }
   public void addContainerProxy(ContainerProxy p) throws PersistenceException{
      this.containerCache.put(p.getId(), p);
   }
   public Map<Integer,ContainerProxy> getContainerCache(){
      return this.containerCache;
   }
   public Root getRoot(Integer id){
      return this.rootCache.get(id).getTheObject();
   }
   public void addRootProxy(RootProxy p) throws PersistenceException{
      this.rootCache.put(p.getId(), p);
   }
   public Map<Integer,RootProxy> getRootCache(){
      return this.rootCache;
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
