/**--- Generated at Fri May 14 10:30:26 CEST 2021 
 * --- Mode = No Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.stateMachineService;
//10 ===== GENERATED: Import Section ==============
import db.executer.PersistenceException;
import generated.stateMachineService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.stateMachineService.proxies.*;
import observation.Observable;
import db.executer.PersistenceExecuterFactory;
import db.executer.PersistenceDMLExecuter;
import db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class StateMachineService extends Observable{
   PersistenceDMLExecuter dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter();
   private Map<Integer,TransitionProxy> transitionCache;
   private Map<Integer,EventProxy> eventCache;
   private Map<Integer,StateProxy> stateCache;
   private Map<Integer,StateMachineProxy> stateMachineCache;
   private static StateMachineService theInstance = new StateMachineService();
   private StateMachineService(){
      try{
         PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().initializeFor("StateMachineService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static StateMachineService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.transitionCache = new InitialProxyLoader<TransitionProxy>("generated", "StateMachineService", "stateMachineService", "Transition", "Transition").perform();
      this.eventCache = new InitialProxyLoader<EventProxy>("generated", "StateMachineService", "stateMachineService", "Event", "Event").perform();
      this.stateCache = new InitialProxyLoader<StateProxy>("generated", "StateMachineService", "stateMachineService", "State", "State").perform();
      this.stateMachineCache = new InitialProxyLoader<StateMachineProxy>("generated", "StateMachineService", "stateMachineService", "StateMachine", "StateMachine").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("SM_StartState").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine", "StateMachineService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State", "StateMachineService");
         try{this.addSM_StartStateElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("SM_States").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine", "StateMachineService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State", "StateMachineService");
         try{this.addSM_StatesElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("SM_Transitions").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine", "StateMachineService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Transition", "StateMachineService");
         try{this.addSM_TransitionsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("SM_events").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "StateMachine", "StateMachineService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Event", "StateMachineService");
         try{this.addSM_eventsElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("TR_from").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Transition", "StateMachineService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State", "StateMachineService");
         try{this.addTR_fromElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("TR_to").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Transition", "StateMachineService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "State", "StateMachineService");
         try{this.addTR_toElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("TR_event").perform().values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Transition", "StateMachineService");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Event", "StateMachineService");
         try{this.addTR_eventElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addSM_StartStateElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; IState proxy2 = null; 
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      SM_StartStateSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addSM_StatesElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; IState proxy2 = null; 
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      SM_StatesSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addSM_TransitionsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; ITransition proxy2 = null; 
      if(className2.equals("Transition"))  proxy2 = this.transitionCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      SM_TransitionsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addSM_eventsElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IStateMachine proxy1 = null; IEvent proxy2 = null; 
      if(className2.equals("Event"))  proxy2 = this.eventCache.get(id2);
      if(className1.equals("StateMachine"))  proxy1 = this.stateMachineCache.get(id1);
      SM_eventsSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addTR_fromElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITransition proxy1 = null; IState proxy2 = null; 
      if(className1.equals("Transition"))  proxy1 = this.transitionCache.get(id1);
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      TR_fromSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addTR_toElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITransition proxy1 = null; IState proxy2 = null; 
      if(className1.equals("Transition"))  proxy1 = this.transitionCache.get(id1);
      if(className2.equals("State"))  proxy2 = this.stateCache.get(id2);
      TR_toSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addTR_eventElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ITransition proxy1 = null; IEvent proxy2 = null; 
      if(className1.equals("Transition"))  proxy1 = this.transitionCache.get(id1);
      if(className2.equals("Event"))  proxy2 = this.eventCache.get(id2);
      TR_eventSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   public Transition getTransition(Integer id){
      return this.transitionCache.get(id).getTheObject();
   }
   public void addTransitionProxy(TransitionProxy p) throws PersistenceException{
      this.transitionCache.put(p.getId(), p);
   }
   public Map<Integer,TransitionProxy> getTransitionCache(){
      return this.transitionCache;
   }
   public Event getEvent(Integer id){
      return this.eventCache.get(id).getTheObject();
   }
   public void addEventProxy(EventProxy p) throws PersistenceException{
      this.eventCache.put(p.getId(), p);
   }
   public Map<Integer,EventProxy> getEventCache(){
      return this.eventCache;
   }
   public State getState(Integer id){
      return this.stateCache.get(id).getTheObject();
   }
   public void addStateProxy(StateProxy p) throws PersistenceException{
      this.stateCache.put(p.getId(), p);
   }
   public Map<Integer,StateProxy> getStateCache(){
      return this.stateCache;
   }
   public StateMachine getStateMachine(Integer id){
      return this.stateMachineCache.get(id).getTheObject();
   }
   public void addStateMachineProxy(StateMachineProxy p) throws PersistenceException{
      this.stateMachineCache.put(p.getId(), p);
   }
   public Map<Integer,StateMachineProxy> getStateMachineCache(){
      return this.stateMachineCache;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().closeConnection();
   }
   //80 ===== Editable : Your Operations =============
/**
 * Inititialisiert einen Automaten
 */
   public StateMachine initialise(State startState, String smName){
      // TODO: Implement Operation initialise
      return null;
   }
//90 ===== GENERATED: End of Your Operations ======
}
