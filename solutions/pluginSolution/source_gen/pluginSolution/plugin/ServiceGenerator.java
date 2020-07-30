package pluginSolution.plugin;

/*Generated by MPS */

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.jetbrains.mps.openapi.model.SNode;
import metaModel.JService;
import utilities.FileCreator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.ArrayList;
import jetbrains.mps.lang.core.behavior.BaseConcept__BehaviorDescriptor;
import java.io.IOException;
import utilities.JServiceXMLWriter;
import java.util.List;
import java.util.Date;
import javax.swing.JOptionPane;
import javaASTTraversals.codeGeneration.JavaGenerator;
import utilities.JServiceXMLReader;
import java.io.File;
import utilities.DirectoryManager;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import metaModel.JException;
import metaModel.JRelationType;
import metaModel.JGeneralisation;
import metaModel.JOperation;
import metaModel.visitorEnabling.JavaASTVisitor;
import javaASTTraversals.referenceCompletion.ReferenceCompletionVisitor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.Method;
import org.jetbrains.mps.openapi.language.SContainmentLink;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import metaModel.JClassLink;
import metaModel.JClassLinkStateUnassigned;
import org.jetbrains.mps.openapi.language.SProperty;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import org.jetbrains.mps.openapi.model.SReference;
import org.jetbrains.mps.openapi.language.SEnumeration;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.baseLanguage.logging.runtime.model.LoggingRuntime;
import org.apache.log4j.Level;
import utilities.FileReader;
import com.thoughtworks.xstream.XStream;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class ServiceGenerator {
  private static final Logger LOG = LogManager.getLogger(ServiceGenerator.class);
  private SNode node;
  private JService jService;
  private String protocolFileDirectory;
  private String javaIDEProjectDirectory;
  private String fileSeparator = System.getProperty("file.separator");
  private FileCreator fileCreator;
  private String xmlFilePath = "";
  private String mpsProjectPath;

  public ServiceGenerator(SNode node, String mpsProjectPath) {
    this.fileCreator = new FileCreator();
    this.node = node;
    this.mpsProjectPath = mpsProjectPath;
    this.determineDirectories();
    this.xmlFilePath = this.protocolFileDirectory + this.fileSeparator + "AST" + SPropertyOperations.getString(this.node, PROPS.name$tAp1) + ".xml";
  }
  public JService getMyService() {
    return this.jService;
  }
  public JService executeService() {
    this.jService = this.processNode(new ArrayList<JService>());
    this.generateJavaCode();
    this.informationMessage("Carried Out Code Generation For " + this.jService.getName() + ". Watch Out For Syntax Errors in Generated Code!!!");
    try {
      this.writeXML();
    } catch (Exception e) {
      this.error("Could not Write XML File: " + e.getClass().getName() + ": " + e.getMessage());
    }
    this.writeProtocol(BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(this.node));
    return this.jService;
  }
  public void writeXML() throws IOException {
    new JServiceXMLWriter(this.jService).save(this.xmlFilePath);
    this.informationMessage("Created XML File at " + this.xmlFilePath);
  }
  public JService processNode(List<JService> otherServices) {
    this.fileCreator.append("STARTING JAVA AST CREATION @ " + new Date().toString());
    try {
      this.appendStartingMessageSingle(this.node);
      this.createJavaASTPhase1();
      this.createJavaASTPhase2(otherServices);
      this.jService.constraintCheck();
      this.informationMessage("Successfully Finished Java AST Creation @ " + new Date().toString());
    } catch (Exception e) {
      this.informationMessage("Java AST Creation was Aborted @ " + new Date().toString());
      String message = e.getClass().getName() + "::: " + e.getMessage();
      if (e.getCause() != null) {
        message = message + ". Cause : " + e.getCause();
      }
      JOptionPane.showMessageDialog(null, message);
    }
    return this.jService;
  }
  public void generateJavaCode() {
    JavaGenerator javaGenerator = new JavaGenerator(this.javaIDEProjectDirectory);
    JServiceXMLReader jsr = new JServiceXMLReader();
    List<Exception> protocol = javaGenerator.executeFor(this.jService, this.xmlFilePath);
    for (Exception e : protocol) {
      this.error(e.getMessage());
    }
  }
  public JService reInitializeService() {
    int answer = JOptionPane.showConfirmDialog(null, "ATTENTION: This will overwrite Your Own Code in All Generated Classes. Do you want to proceed?");
    if (answer != JOptionPane.YES_OPTION) {
      return null;
    }
    File aSTFile = new File(this.xmlFilePath);
    aSTFile.delete();
    this.deleteDirectory(DirectoryManager.determineTargetDirectory(javaIDEProjectDirectory, SPropertyOperations.getString(this.node, PROPS.name$tAp1)));
    return this.executeService();
  }
  private boolean deleteDirectory(File d) {
    File[] files = d.listFiles();
    for (int i = 0; i < files.length; i++) {
      files[i].delete();
    }
    return d.delete();
  }
  private void createJavaASTPhase1() throws Exception {
    //  First pass of transformation: Transforms all Nodes to Java Objects, defers creation of target nodes of references, if target node has not been processed before source node  
    // // TODO: At the moment only references to JCLASS can be created in a deferred way 
    // // TODO: To reuse Exceptions vie references, JException has to be treated this way, too  
    // // If references to JASSOCIATION's can be deferred, this simply enables recursive date types     
    this.informationMessage("--> Starting Transformation Phase 1");
    //  Root node is stored in JServiceContainer to be able to access it later on 
    //  This is a relict from the time when I did not know that I can develop separate classes here 
    this.jService = new JService(BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(this.node));
    //  All directly contained nodes are explicitely PREPROCESSED 
    for (SNode exception : ListSequence.fromList(SLinkOperations.getChildren(this.node, LINKS.exceptions$lD8a))) {
      this.jService.addException(((JException) this.createJavaNode(exception)));
    }
    for (SNode relationType : ListSequence.fromList(SLinkOperations.getChildren(this.node, LINKS.relationTypes$xfVD))) {
      this.jService.addRelationType(((JRelationType) this.createJavaNode(relationType)));
    }
    for (SNode generalisation : ListSequence.fromList(SLinkOperations.getChildren(this.node, LINKS.generalisations$nqoF))) {
      this.jService.addGeneralisation(((JGeneralisation) this.createJavaNode(generalisation)));
    }
    for (SNode serviceOperation : ListSequence.fromList(SLinkOperations.getChildren(this.node, LINKS.operations$L8Cd))) {
      this.jService.addOperation(((JOperation) this.createJavaNode(serviceOperation)));
    }
  }
  private void createJavaASTPhase2(List<JService> otherServices) {
    boolean exceptionOccured = false;
    this.informationMessage("--> Starting Transformation Phase 2 ");
    JavaASTVisitor visitor = new ReferenceCompletionVisitor(this.jService, otherServices);
    this.jService.accept(visitor);
    for (Exception currentException : visitor.getProtocol()) {
      exceptionOccured = true;
      this.error("Exception in Phase 2: " + currentException.getMessage());
    }
    this.informationMessage("--> Finished Transformation Phase 2 (assigning all unassigned references)" + ((exceptionOccured ? " with errors." : " with no errors.")));
  }

  private Object createJavaNode(SNode currentNode) throws Exception {
    this.appendStartingMessageSingle(currentNode);
    Constructor javaConstructor = this.getJavaConstructorFor(currentNode);
    // Goal: Provide each parameter of this constructor with the correct value 
    Parameter[] constructorParameters = javaConstructor.getParameters();
    Object[] constructorParameterValues = new Object[javaConstructor.getParameterCount()];
    for (int i = 0; i < javaConstructor.getParameterCount(); i++) {
      constructorParameterValues[i] = this.createConstructorParameterValue(constructorParameters[i], currentNode);
    }
    Object result = javaConstructor.newInstance(constructorParameterValues);

    //  Iterate over add-Methods of java class and add children of [*]-children-features, e.g. addOperation(op:JOperation), addAttribute(a:JAttributeConnector) 
    for (Method currentAddMethod : this.getAddMethods(currentNode)) {
      String javaFeatureName = this.extractFeatureNameFromNameOfAddMethod(currentAddMethod.getName());
      this.informationMessage("Adding children according to " + currentAddMethod.getName() + "(Feature " + javaFeatureName + ") in Java Class " + result.getClass());
      for (SContainmentLink child : CollectionSequence.fromCollection(SNodeOperations.getConcept(currentNode).getContainmentLinks())) {
        if (child.getName().equals(javaFeatureName) && child.isMultiple()) {
          for (SNode childInstance : ListSequence.fromList(SNodeOperations.getChildren(currentNode))) {
            if (SNodeOperations.getContainingLink(childInstance).getName().equals(javaFeatureName)) {
              currentAddMethod.invoke(result, this.createJavaNode(childInstance));
            }
          }
        }
      }
    }
    return result;
  }

  private Object fetchJavaNode(SNode targetNode) throws Exception {
    //  PRECONDITION: If the referenced node's concept is not "Class", it must  already be constructed 
    this.informationMessage("Fetching already created Java Node for referenced node " + BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(targetNode) + " of concept " + SNodeOperations.getConcept(targetNode).getName());
    Method getter = this.findMethod(SNodeOperations.getConcept(targetNode).getName());
    this.informationMessage("Invoking method " + getter.toString() + " with actual parameter: " + BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(targetNode));
    Object result = getter.invoke(this.jService, BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(targetNode));
    if (SNodeOperations.getConcept(targetNode).getName().equals("Class")) {
      //  Exceptional case: When referenced, JClasses are wrapped in JClassLinks to enable deferred creation 
      this.informationMessage("Creating JClassLink-Instance to JClass " + BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(targetNode));
      return new JClassLink(BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(targetNode), new JClassLinkStateUnassigned());
    } else {
      return result;
    }
  }
  private Object createConstructorParameterValue(Parameter constructorParameter, SNode currentNode) throws Exception {
    // 1. Determine property, unary child, or reference which corresponds to <constructorParameter> by name equality 
    // 2. If no such property, unary child, or reference is found, append protocol with error and abort transformation  
    // 3. Otherwise: We found one of the following  
    //         - property:  A terminal node is created and returned  
    //         - unary child: Iterate over all childInstances of currentNode and return the Java Node, which is created from            the childInstance whose link name = constructor parameter's name,  
    //           If none found, we return null, which occurs in the case of [0..1] cardinality and is the legal value for the              Java Constructor parameter 
    //         - reference: A referenced node is fetched and returned - if none found an unassigned link is created and assigned in a second pass 
    this.informationMessage("Construction of constructor-parameter-value for " + constructorParameter.getName() + ":" + constructorParameter.getType().getName());
    SProperty property = this.tryGetProperty(constructorParameter.getName(), currentNode);
    if (property != null) {
      return this.createJavaNodeForProperty(property, currentNode, constructorParameter);
    }
    SContainmentLink child = this.tryGetChild(constructorParameter.getName(), currentNode);
    if (child != null) {
      for (SNode childInstance : ListSequence.fromList(SNodeOperations.getChildren(currentNode))) {
        if (SNodeOperations.getContainingLink(childInstance).getName().equals(constructorParameter.getName())) {
          return this.createJavaNode(childInstance);
        }
      }
      this.informationMessage("No value found for " + " child " + child.getName() + ". That's ok, because its optionality value is " + child.isOptional());
      return null;
    }
    SReferenceLink reference = this.tryGetReference(constructorParameter.getName(), currentNode);
    if (reference != null) {
      for (SReference referenceInstance : ListSequence.fromList(SNodeOperations.getReferences(currentNode))) {
        if (SLinkOperations.getRefLink(referenceInstance).getName().equals(constructorParameter.getName())) {
          return this.fetchJavaNode(referenceInstance.getTargetNode());
        }
      }
      this.informationMessage("No Value found for " + " Reference " + reference.getName() + ". That's ok, because its optionality Value is " + reference.isOptional());
      return null;
    }
    this.error("No property, child, or reference found in concept " + BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(currentNode) + " for Java constructor parameter " + constructorParameter.getName() + ":" + constructorParameter.getType().getName());
    throw new Exception(this.abortionText());
  }
  private SProperty tryGetProperty(String constructorParametername, SNode currentNode) {
    //  Returns the property of currentNode's concept, which corresponds to constructorParameterName. May return null, if no such property has been found 
    for (SProperty currentProperty : CollectionSequence.fromCollection(SNodeOperations.getConcept(currentNode).getProperties())) {
      if (currentProperty.getName().equals(constructorParametername)) {
        return currentProperty;
      }
    }
    return null;
  }
  private SContainmentLink tryGetChild(String constructorParametername, SNode currentNode) {
    //  Returns the non-multiple child of currentNode's concept, which corresponds to constructorParameterName. May return null, if no such child has been found 
    for (SContainmentLink child : CollectionSequence.fromCollection(SNodeOperations.getConcept(currentNode).getContainmentLinks())) {
      if (child.getName().equals(constructorParametername) && !((child.isMultiple()))) {
        return child;
      }
    }
    return null;
  }
  private SReferenceLink tryGetReference(String constructorParametername, SNode currentNode) {
    //  Returns a reference link of the currentNode's concept, which corresponds to constructorParameterName. May return null, if no such reference has been found 
    for (SReferenceLink referenceLink : CollectionSequence.fromCollection(SNodeOperations.getConcept(currentNode).getReferenceLinks())) {
      if (referenceLink.getName().equals(constructorParametername)) {
        return referenceLink;
      }
    }
    return null;
  }
  private Constructor getJavaConstructorFor(SNode currentNode) throws Exception {
    // Retrieve THE constructor 
    try {
      return this.conceptToJavaClass(SNodeOperations.getConcept(currentNode)).getConstructors()[0];
    } catch (Exception e) {
      this.exceptionToProtocol(e, currentNode);
      throw new Exception(this.abortionText());
    }
  }
  private Object getEnumerationValueFor(String className, SProperty property) throws Exception {
    this.informationMessage("Retrieving enumeration value of type J" + className + " for property " + property.getName());
    try {
      //  Java API says: "Invocation of static method allows parameter of invoke to be null" 
      return Class.forName("metaModel.enumerations.J" + className).getMethod("instance").invoke(null);
    } catch (Exception e) {
      this.exceptionToProtocol(e, property, "Could not retrieve singleton of " + className);
      throw new Exception(this.abortionText());
    }
  }
  private Object createJavaNodeForProperty(SProperty property, SNode currentNode, Parameter constructorParameter) throws Exception {
    this.informationMessage("Transforming value " + currentNode.getProperty(property) + " of property " + property.getName());
    if (property.getType() instanceof SEnumeration) {
      // Exceptional case Enumeration: The value comes as <id>/<EnumerationValue>, e.g. 6A5B5/Injective 
      // This value is null, if it has the default value (Greetings to the MPS group)   
      // However the default value of the enumeration has no <id>  
      if (currentNode.getProperty(property) != null) {
        return this.getEnumerationValueFor(currentNode.getProperty(property).split("/")[1], property);
      } else {
        SEnumeration propertyType = ((SEnumeration) property.getType());
        return this.getEnumerationValueFor(propertyType.getDefault().getName(), property);
      }
    } else {
      // The property has an MPS base type (boolean, string, int) 
      // Again the value can be null, which represents the default value of this base type 
      Constructor constr = constructorParameter.getType().getConstructor(String.class);
      if (currentNode.getProperty(property) != null) {
        return constr.newInstance(currentNode.getProperty(property).toString());
      } else {
        return constr.newInstance(this.getDefaultValueOfPrimitiveJavaTypeAsString(constructorParameter.getType().getName()));
      }
    }
  }
  private Method findMethod(String javaClassNameWithoutJ) throws ClassNotFoundException, NoSuchMethodException {
    //  Search a method in JService with signature get<targetNode.concept.getName()>(name:String) 
    // If not found there may be a method get<X> with JX a direct or indirect super type of J<targetNode.concept.getName()> 
    // We URGENTLY assume that the type hierarchy in the "metaModel"- package is bottom up linear, i.e. each class either has a super class or one interface, each interface has at most one interface 
    try {
      this.informationMessage("Searching for method get" + javaClassNameWithoutJ);
      return JService.class.getMethod("get" + javaClassNameWithoutJ, String.class);
    } catch (NoSuchMethodException nsme) {
      Class classInGetMethod = Class.forName(this.getPrefixForJavaClass() + javaClassNameWithoutJ);
      if (classInGetMethod.getSuperclass().equals(Object.class)) {
        //  Search interface 
        if (classInGetMethod.getInterfaces().length > 0) {
          this.informationMessage("Not found! Try getX with X the implemented interface");
          return this.findMethod(this.javaClassNameToMPSConceptName(classInGetMethod.getInterfaces()[0].getSimpleName()));
        }
        throw new NoSuchMethodException("No getter found in class JService for objects of type J" + javaClassNameWithoutJ);
      }
      String next = this.javaClassNameToMPSConceptName(classInGetMethod.getSuperclass().getSimpleName());
      this.informationMessage("Not found! Try get" + next);
      return this.findMethod(next);
    }
  }
  private String extractFeatureNameFromNameOfAddMethod(String nameOfAddMethod) {
    // addTheFeature -> TheFeature  
    String result = nameOfAddMethod.substring(3);
    //  TheFeature -> theFeatures 
    return result.substring(0, 1).toLowerCase() + result.substring(1) + "s";
  }
  private List<Method> getAddMethods(SNode currentNode) throws Exception {
    List<Method> result = new ArrayList<Method>();
    Method[] allMethods = this.conceptToJavaClass(SNodeOperations.getConcept(currentNode)).getMethods();
    for (int i = 0; i < allMethods.length; i++) {
      if (allMethods[i].getName().startsWith("add")) {
        result.add(allMethods[i]);
      }
    }
    return result;
  }
  private String getDefaultValueOfPrimitiveJavaTypeAsString(String primitiveTypeName) {
    switch (primitiveTypeName) {
      case "java.lang.String":
        return "";
      case "java.lang.Integer":
        return "0";
      case "java.lang.Boolean":
        return "false";
      default:
        return "";
    }
  }
  private Class conceptToJavaClass(SAbstractConcept concept) throws Exception {
    return Class.forName(this.getPrefixForJavaClass() + concept.getName());
  }
  private String abortionText() {
    return "Transformation aborted, see protocol file";
  }
  private void exceptionToProtocol(Exception e, SNode currentNode) {
    this.error("Exception occured during creation of " + BaseConcept__BehaviorDescriptor.getPresentation_idhEwIMiw.invoke(currentNode) + ": " + e.getMessage());
  }
  private void exceptionToProtocol(Exception e, SProperty property, String additionalInfo) {
    this.error("Exception occured during creation of " + property.getName() + ": " + e.getMessage() + ", " + additionalInfo);
  }
  public void writeProtocol(String serviceName) {
    try {
      //  E.g. "C:/Temp/" + serviceName + ".txt" 
      String filePath = this.protocolFileDirectory + this.fileSeparator + serviceName + ".txt";
      this.fileCreator.createFile(new File(filePath));
      LoggingRuntime.logMsgView(Level.INFO, "Transformation finished. See protocol file " + this.protocolFileDirectory + "/" + serviceName + ".txt", ServiceGenerator.class, null, null);
    } catch (Exception ex) {
      LoggingRuntime.logMsgView(Level.ERROR, "IO-Error when writing Protocol File ", ServiceGenerator.class, ex, null);
    }
  }
  private void appendStartingMessageSingle(SNode currentNode) {
    this.fileCreator.append("Start Transforming " + currentNode);
  }
  public void informationMessage(String s) {
    this.fileCreator.append("Information: " + s);
  }
  private void error(String s) {
    this.fileCreator.append("       ---->Error: " + s);
  }
  private String getPrefixForJavaClass() {
    return "metaModel.J";
  }
  private String javaClassNameToMPSConceptName(String javaClassName) {
    //  Cut off the "J" 
    return javaClassName.substring(1);
  }
  private void determineDirectories() {
    try {
      List<String> lines = FileReader.readAsStringList(this.mpsProjectPath + this.fileSeparator + "configuration.txt");
      // Line 1: protocolFileDirectory = (e.g.) C:/Temp 
      this.protocolFileDirectory = lines.get(0).split("=")[1].trim();
      // Line 2: eclipseProjectDirectory = (e.g.) C:/D/JavaWorkspace/MDEGen 
      this.javaIDEProjectDirectory = lines.get(1).split("=")[1].trim();
    } catch (Exception e) {
      this.informationMessage("Could not find the Configuration file. Using default Destinations C:/Temp.");
      this.protocolFileDirectory = "C:" + this.fileSeparator + "Temp";
      this.javaIDEProjectDirectory = "C:" + this.fileSeparator + "Temp";
    }
  }
  private void streamTest() {
    // Temporary only for testing, same for next method 
    File f = new File("C:/Temp/hope.txt");
    try {
      XStream y = new XStream();
      JService js = ((JService) y.fromXML(f));
      JOptionPane.showMessageDialog(null, "Successfully retrieved object from XML: " + js.getName());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Exception When reading from XML: " + e.getMessage());
    }
  }
  private void streamTestComplete() {
    File f = new File("C:/Temp/hope.txt");
    XStream x = new XStream();
    String xmlContents = x.toXML(this.jService);
    FileCreator fc = new FileCreator();
    fc.append(xmlContents);
    try {
      fc.createFile(f);
      JOptionPane.showMessageDialog(null, "Successfully created XML File: ");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Exception when creating XML File: " + e.getMessage());
    }
    try {
      XStream y = new XStream();
      JService js = ((JService) y.fromXML(f));
      JOptionPane.showMessageDialog(null, "Successfully retrieved object from XML: " + js.getName());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Exception when reading from XML: " + e.getMessage());
    }

  }


  private static final class PROPS {
    /*package*/ static final SProperty name$tAp1 = MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name");
  }

  private static final class LINKS {
    /*package*/ static final SContainmentLink exceptions$lD8a = MetaAdapterFactory.getContainmentLink(0x9859e7a148764909L, 0xa6648a214c206698L, 0x355f4a6bd0ef9b51L, 0x355f4a6bd0efcad9L, "exceptions");
    /*package*/ static final SContainmentLink relationTypes$xfVD = MetaAdapterFactory.getContainmentLink(0x9859e7a148764909L, 0xa6648a214c206698L, 0x355f4a6bd0ef9b51L, 0x355f4a6bd0ef9b54L, "relationTypes");
    /*package*/ static final SContainmentLink generalisations$nqoF = MetaAdapterFactory.getContainmentLink(0x9859e7a148764909L, 0xa6648a214c206698L, 0x355f4a6bd0ef9b51L, 0x355f4a6bd0f11e99L, "generalisations");
    /*package*/ static final SContainmentLink operations$L8Cd = MetaAdapterFactory.getContainmentLink(0x9859e7a148764909L, 0xa6648a214c206698L, 0x355f4a6bd0ef9b51L, 0x5b448949fec5dbf4L, "operations");
  }
}
