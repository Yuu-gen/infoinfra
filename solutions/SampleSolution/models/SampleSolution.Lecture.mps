<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:8a1101ed-962a-4696-a62f-4c748027cca5(SampleSolution.Lecture)">
  <persistence version="9" />
  <languages>
    <use id="9859e7a1-4876-4909-a664-8a214c206698" name="MetaModel" version="0" />
  </languages>
  <imports />
  <registry>
    <language id="9859e7a1-4876-4909-a664-8a214c206698" name="MetaModel">
      <concept id="1342586541813388693" name="MetaModel.structure.Bidirectional" flags="ng" index="2zC0rd">
        <property id="1342586541813388710" name="domainEndSpecification" index="2zC0rY" />
        <child id="1342586541813388712" name="connector" index="2zC0rK" />
      </concept>
      <concept id="1342586541813396118" name="MetaModel.structure.ConstrainedTargetConnector" flags="ng" index="2zC27e">
        <property id="1342586541813396133" name="constraint" index="2zC27X" />
      </concept>
      <concept id="1342586541813382694" name="MetaModel.structure.OwnerConnector" flags="ng" index="2zC6PY">
        <reference id="1342586541813382695" name="ownerType" index="2zC6PZ" />
      </concept>
      <concept id="6576532306767764478" name="MetaModel.structure.AttributeConnector" flags="ng" index="2_wlaR" />
      <concept id="1967123554055742618" name="MetaModel.structure.TypeAdapter" flags="ng" index="BxOjD">
        <reference id="1967123554055742621" name="type" index="BxOjI" />
      </concept>
      <concept id="3845874433725122187" name="MetaModel.structure.Unidirectional" flags="ng" index="3_FwNw">
        <reference id="3845874433725122188" name="ownerType" index="3_FwNB" />
      </concept>
      <concept id="3845874433725109376" name="MetaModel.structure.Generalisation" flags="ng" index="3_F_VF">
        <reference id="3845874433725109379" name="specific" index="3_F_VC" />
        <reference id="3845874433725109377" name="general" index="3_F_VE" />
      </concept>
      <concept id="3845874433725116463" name="MetaModel.structure.TargetConnector" flags="ng" index="3_FBD4">
        <reference id="3845874433725116464" name="targetType" index="3_FBDr" />
      </concept>
      <concept id="3845874433725116460" name="MetaModel.structure.Connector" flags="ng" index="3_FBD7">
        <property id="3845874433725116461" name="role" index="3_FBD6" />
      </concept>
      <concept id="3845874433725116455" name="MetaModel.structure.Association" flags="ng" index="3_FBDc">
        <child id="3845874433725125412" name="target" index="3_Fx_f" />
        <child id="3845874433725125405" name="owner" index="3_Fx_Q" />
      </concept>
      <concept id="3845874433725012803" name="MetaModel.structure.Exception" flags="ng" index="3_Gd4C">
        <property id="3845874433725012806" name="errorText" index="3_Gd4H" />
      </concept>
      <concept id="3845874433725012817" name="MetaModel.structure.Service" flags="ng" index="3_Gd4U">
        <child id="6576532306767764468" name="operations" index="2_wlaX" />
        <child id="3845874433725111961" name="generalisations" index="3_F_jM" />
        <child id="3845874433725024985" name="exceptions" index="3_G82M" />
        <child id="3845874433725012820" name="relationTypes" index="3_Gd4Z" />
      </concept>
      <concept id="3845874433725012776" name="MetaModel.structure.PrimitiveType" flags="ng" index="3_Gd53" />
      <concept id="3845874433725012781" name="MetaModel.structure.Class" flags="ng" index="3_Gd56">
        <child id="6576532306767764487" name="attributes" index="2_wlle" />
        <child id="3845874433725012801" name="operations" index="3_Gd4E" />
      </concept>
      <concept id="3845874433725012784" name="MetaModel.structure.Operation" flags="ng" index="3_Gd5r">
        <property id="8111959590477224782" name="abstrakt" index="3e9aca" />
        <property id="3845874433725012787" name="readableName" index="3_Gd5o" />
        <property id="3845874433725012785" name="techName" index="3_Gd5q" />
        <property id="3845874433725012790" name="documentation" index="3_Gd5t" />
        <reference id="7979841542586465541" name="exception" index="3NuQEv" />
        <child id="1967123554056188092" name="returnType" index="BBx3f" />
        <child id="3845874433725021043" name="formalParameters" index="3_Gf4o" />
      </concept>
      <concept id="3845874433725021038" name="MetaModel.structure.Parameter" flags="ng" index="3_Gf45">
        <child id="1967123554056188103" name="type" index="BBx2O" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="3_Gd4U" id="5H4ykBYMXjP">
    <property role="TrG5h" value="baseTypes" />
    <node concept="3_Gd53" id="5H4ykBYMXjQ" role="3_Gd4Z">
      <property role="TrG5h" value="String" />
    </node>
    <node concept="3_Gd53" id="5H4ykBYMXjV" role="3_Gd4Z">
      <property role="TrG5h" value="Integer" />
    </node>
    <node concept="3_Gd53" id="5H4ykBYMXk3" role="3_Gd4Z">
      <property role="TrG5h" value="Rational" />
    </node>
    <node concept="3_Gd53" id="5H4ykBYMXkd" role="3_Gd4Z">
      <property role="TrG5h" value="Boolean" />
    </node>
  </node>
  <node concept="3_Gd4U" id="5Q6229Kztdj">
    <property role="TrG5h" value="FileService" />
    <node concept="3_Gd56" id="5Q6229Kztdk" role="3_Gd4Z">
      <property role="TrG5h" value="Element" />
      <node concept="2_wlaR" id="5Q6229Kztdm" role="2_wlle">
        <property role="3_FBD6" value="name" />
        <property role="2zC27X" value="1axOPyL0vao/PartialMap" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
      <node concept="3_Gd5r" id="5Q6229KA4zr" role="3_Gd4E">
        <property role="3_Gd5q" value="contains" />
        <property role="3_Gd5o" value="contains" />
        <property role="3_Gd5t" value="Prueft, ob element direkt oder indirekt in this enthalten ist oder ob element==this ist" />
        <property role="3e9aca" value="true" />
        <node concept="3_Gf45" id="5Q6229KA4zt" role="3_Gf4o">
          <property role="TrG5h" value="element" />
          <node concept="BxOjD" id="5Q6229KA4zx" role="BBx2O">
            <ref role="BxOjI" node="5Q6229Kztdk" resolve="Element" />
          </node>
        </node>
        <node concept="BxOjD" id="5Q6229KA4z$" role="BBx3f">
          <ref role="BxOjI" node="5H4ykBYMXkd" resolve="Boolean" />
        </node>
      </node>
    </node>
    <node concept="3_Gd56" id="5Q6229Kztdu" role="3_Gd4Z">
      <property role="TrG5h" value="Directory" />
      <node concept="3_Gd5r" id="5Q6229KA4zi" role="3_Gd4E">
        <property role="3_Gd5q" value="addElement" />
        <property role="3_Gd5o" value="addElement" />
        <property role="3_Gd5t" value="Fuegt element zu this hinzu, wenn element nicht this enthält und element ungleich this ist. Im anderen Fall wird CycleException geworfen" />
        <ref role="3NuQEv" node="5Q6229KA4zg" resolve="CycleException" />
        <node concept="3_Gf45" id="5Q6229KA4zk" role="3_Gf4o">
          <property role="TrG5h" value="element" />
          <node concept="BxOjD" id="5Q6229KA4zo" role="BBx2O">
            <ref role="BxOjI" node="5Q6229Kztdk" resolve="Element" />
          </node>
        </node>
      </node>
    </node>
    <node concept="3_Gd56" id="5Q6229KztdC" role="3_Gd4Z">
      <property role="TrG5h" value="File" />
      <node concept="2_wlaR" id="2o$bHIf1Lhy" role="2_wlle">
        <property role="3_FBD6" value="size" />
        <ref role="3_FBDr" node="5H4ykBYMXk3" resolve="Rational" />
      </node>
    </node>
    <node concept="3_F_VF" id="5Q6229KA4zb" role="3_F_jM">
      <ref role="3_F_VE" node="5Q6229Kztdk" resolve="Element" />
      <ref role="3_F_VC" node="5Q6229KztdC" resolve="File" />
    </node>
    <node concept="3_F_VF" id="5Q6229KA4zd" role="3_F_jM">
      <ref role="3_F_VC" node="5Q6229Kztdu" resolve="Directory" />
      <ref role="3_F_VE" node="5Q6229Kztdk" resolve="Element" />
    </node>
    <node concept="3_Gd4C" id="5Q6229KA4zg" role="3_G82M">
      <property role="TrG5h" value="CycleException" />
      <property role="3_Gd4H" value="Cycle detected" />
    </node>
    <node concept="3_FBDc" id="vSMGqqOkLB" role="3_Gd4Z">
      <property role="TrG5h" value="Dir_Has_Elements" />
      <node concept="2zC0rd" id="vSMGqqOkLW" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmn/Injective" />
        <node concept="2zC6PY" id="vSMGqqOkLY" role="2zC0rK">
          <property role="3_FBD6" value="container" />
          <ref role="2zC6PZ" node="5Q6229Kztdu" resolve="Directory" />
        </node>
      </node>
      <node concept="2zC27e" id="vSMGqqOkM2" role="3_Fx_f">
        <property role="3_FBD6" value="elements" />
        <property role="2zC27X" value="5H4ykBYL_dN/List" />
        <ref role="3_FBDr" node="5Q6229Kztdk" resolve="Element" />
      </node>
    </node>
  </node>
  <node concept="3_Gd4U" id="1ZLMV0d4Y2W">
    <property role="TrG5h" value="FileServiceWithContainment" />
    <node concept="3_Gd56" id="1ZLMV0d4Y2X" role="3_Gd4Z">
      <property role="TrG5h" value="Container" />
    </node>
    <node concept="3_Gd56" id="1ZLMV0d4Y32" role="3_Gd4Z">
      <property role="TrG5h" value="Containee" />
    </node>
    <node concept="3_Gd56" id="1ZLMV0d4Y3a" role="3_Gd4Z">
      <property role="TrG5h" value="Root" />
    </node>
    <node concept="3_Gd56" id="1ZLMV0d4Y3k" role="3_Gd4Z">
      <property role="TrG5h" value="Directory" />
    </node>
    <node concept="3_Gd56" id="1ZLMV0d4Y3w" role="3_Gd4Z">
      <property role="TrG5h" value="File" />
    </node>
    <node concept="3_FBDc" id="1ZLMV0d4Y3N" role="3_Gd4Z">
      <property role="TrG5h" value="CerToCee" />
      <node concept="2zC27e" id="1ZLMV0d4Y4f" role="3_Fx_f">
        <property role="3_FBD6" value="contents" />
        <property role="2zC27X" value="1axOPyL0vaw/Set" />
        <ref role="3_FBDr" node="1ZLMV0d4Y32" resolve="Containee" />
      </node>
      <node concept="2zC0rd" id="1ZLMV0d4Y49" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmr/Containment" />
        <node concept="2zC6PY" id="1ZLMV0d4Y4b" role="2zC0rK">
          <property role="3_FBD6" value="containedIn" />
          <ref role="2zC6PZ" node="1ZLMV0d4Y2X" resolve="Container" />
        </node>
      </node>
    </node>
    <node concept="3_FBDc" id="1ZLMV0d4Y4y" role="3_Gd4Z">
      <property role="TrG5h" value="RootToCer" />
      <node concept="3_FwNw" id="1ZLMV0d4Y4O" role="3_Fx_Q">
        <ref role="3_FwNB" node="1ZLMV0d4Y3a" resolve="Root" />
      </node>
      <node concept="2zC27e" id="1ZLMV0d4Y4R" role="3_Fx_f">
        <property role="3_FBD6" value="container" />
        <property role="2zC27X" value="1axOPyL0vap/TotalMap" />
        <ref role="3_FBDr" node="1ZLMV0d4Y2X" resolve="Container" />
      </node>
    </node>
    <node concept="3_FBDc" id="1ZLMV0d4Y58" role="3_Gd4Z">
      <property role="TrG5h" value="DirToCer" />
      <node concept="3_FwNw" id="1ZLMV0d4Y5t" role="3_Fx_Q">
        <ref role="3_FwNB" node="1ZLMV0d4Y3k" resolve="Directory" />
      </node>
      <node concept="2zC27e" id="1ZLMV0d4Y5w" role="3_Fx_f">
        <property role="3_FBD6" value="container" />
        <property role="2zC27X" value="1axOPyL0vap/TotalMap" />
        <ref role="3_FBDr" node="1ZLMV0d4Y2X" resolve="Container" />
      </node>
    </node>
    <node concept="3_F_VF" id="1ZLMV0d4Y4i" role="3_F_jM">
      <ref role="3_F_VC" node="1ZLMV0d4Y3k" resolve="Directory" />
      <ref role="3_F_VE" node="1ZLMV0d4Y32" resolve="Containee" />
    </node>
    <node concept="3_F_VF" id="1ZLMV0d4Y4k" role="3_F_jM">
      <ref role="3_F_VE" node="1ZLMV0d4Y32" resolve="Containee" />
      <ref role="3_F_VC" node="1ZLMV0d4Y3w" resolve="File" />
    </node>
  </node>
  <node concept="3_Gd4U" id="73qKrKUOsUF">
    <property role="TrG5h" value="StateMachineService" />
    <node concept="3_Gd56" id="4rqLd8XDi5P" role="3_Gd4Z">
      <property role="TrG5h" value="Transition" />
    </node>
    <node concept="3_Gd56" id="4rqLd8XDi2a" role="3_Gd4Z">
      <property role="TrG5h" value="Event" />
      <node concept="2_wlaR" id="4rqLd8XDi2_" role="2_wlle">
        <property role="3_FBD6" value="label" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
    </node>
    <node concept="3_Gd56" id="4rqLd8XDi0j" role="3_Gd4Z">
      <property role="TrG5h" value="State" />
      <node concept="2_wlaR" id="4rqLd8XDi0$" role="2_wlle">
        <property role="3_FBD6" value="name" />
        <property role="2zC27X" value="1axOPyL0vao/PartialMap" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
      <node concept="2_wlaR" id="4rqLd8XDi0A" role="2_wlle">
        <property role="3_FBD6" value="isFinal" />
        <ref role="3_FBDr" node="5H4ykBYMXkd" resolve="Boolean" />
      </node>
    </node>
    <node concept="3_Gd56" id="73qKrKUOsUG" role="3_Gd4Z">
      <property role="TrG5h" value="StateMachine" />
      <node concept="3_Gd5r" id="4rqLd8XDigQ" role="3_Gd4E">
        <property role="3_Gd5q" value="changeStartState" />
        <property role="3_Gd5o" value="changeStartState" />
        <property role="3_Gd5t" value="Aendert den Startzustand zu dem Zustand z0." />
        <node concept="3_Gf45" id="4rqLd8XDih8" role="3_Gf4o">
          <property role="TrG5h" value="z0" />
          <node concept="BxOjD" id="4rqLd8XDihc" role="BBx2O">
            <ref role="BxOjI" node="4rqLd8XDi0j" resolve="State" />
          </node>
        </node>
      </node>
      <node concept="3_Gd5r" id="4rqLd8XDhZu" role="3_Gd4E">
        <property role="3_Gd5q" value="addState" />
        <property role="3_Gd5o" value="addState" />
        <property role="3_Gd5t" value="Fuegt einen Zustand mit Namen name hinzu, der Endzustand ist, sofern isFinal = true." />
        <node concept="3_Gf45" id="4rqLd8XDhZ$" role="3_Gf4o">
          <property role="TrG5h" value="name" />
          <node concept="BxOjD" id="4rqLd8XDhZC" role="BBx2O">
            <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
          </node>
        </node>
        <node concept="3_Gf45" id="4rqLd8XDhZF" role="3_Gf4o">
          <property role="TrG5h" value="isFinal" />
          <node concept="BxOjD" id="4rqLd8XDhZL" role="BBx2O">
            <ref role="BxOjI" node="5H4ykBYMXkd" resolve="Boolean" />
          </node>
        </node>
      </node>
      <node concept="3_Gd5r" id="4rqLd8XDhZO" role="3_Gd4E">
        <property role="3_Gd5q" value="addTransition" />
        <property role="3_Gd5o" value="addTransition" />
        <property role="3_Gd5t" value="Fuegt eine Transition mit Zustand &quot;for&quot;, Zustand &quot;to&quot; und Event &quot;event&quot; hinzu." />
        <node concept="3_Gf45" id="4rqLd8XDhZZ" role="3_Gf4o">
          <property role="TrG5h" value="from" />
          <node concept="BxOjD" id="4rqLd8XDi0D" role="BBx2O">
            <ref role="BxOjI" node="4rqLd8XDi0j" resolve="State" />
          </node>
        </node>
        <node concept="3_Gf45" id="4rqLd8XDi1v" role="3_Gf4o">
          <property role="TrG5h" value="to" />
          <node concept="BxOjD" id="4rqLd8XDi1_" role="BBx2O">
            <ref role="BxOjI" node="4rqLd8XDi0j" resolve="State" />
          </node>
        </node>
        <node concept="3_Gf45" id="4rqLd8XDi1C" role="3_Gf4o">
          <property role="TrG5h" value="event" />
          <node concept="BxOjD" id="4rqLd8XDi2B" role="BBx2O">
            <ref role="BxOjI" node="4rqLd8XDi2a" resolve="Event" />
          </node>
        </node>
      </node>
      <node concept="2_wlaR" id="73qKrKUOsUI" role="2_wlle">
        <property role="3_FBD6" value="name" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
      <node concept="3_Gd5r" id="73qKrKUOsUK" role="3_Gd4E">
        <property role="3_Gd5q" value="validate" />
        <property role="3_Gd5o" value="validate" />
        <property role="3_Gd5t" value="Validiert ob, das Wort w von diesem Automaten erkannt wird" />
        <node concept="3_Gf45" id="73qKrKUOsUM" role="3_Gf4o">
          <property role="TrG5h" value="w" />
          <node concept="BxOjD" id="73qKrKUOsUQ" role="BBx2O">
            <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
          </node>
        </node>
        <node concept="BxOjD" id="73qKrKUOsUT" role="BBx3f">
          <ref role="BxOjI" node="5H4ykBYMXkd" resolve="Boolean" />
        </node>
      </node>
    </node>
    <node concept="3_Gd5r" id="73qKrKUOsV3" role="2_wlaX">
      <property role="3_Gd5q" value="initialise" />
      <property role="3_Gd5o" value="initialise" />
      <property role="3_Gd5t" value="Inititialisiert einen Automaten" />
      <node concept="3_Gf45" id="73qKrKUOsV5" role="3_Gf4o">
        <property role="TrG5h" value="startStateName" />
        <node concept="BxOjD" id="73qKrKUOsV9" role="BBx2O">
          <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
        </node>
      </node>
      <node concept="BxOjD" id="73qKrKUOsVc" role="BBx3f">
        <ref role="BxOjI" node="73qKrKUOsUG" resolve="StateMachine" />
      </node>
    </node>
    <node concept="3_FBDc" id="4rqLd8XDi0Z" role="3_Gd4Z">
      <property role="TrG5h" value="SM_StartState" />
      <node concept="3_FwNw" id="4rqLd8XDi1p" role="3_Fx_Q">
        <ref role="3_FwNB" node="73qKrKUOsUG" resolve="StateMachine" />
      </node>
      <node concept="2zC27e" id="4rqLd8XDi1s" role="3_Fx_f">
        <property role="3_FBD6" value="startState" />
        <ref role="3_FBDr" node="4rqLd8XDi0j" resolve="State" />
      </node>
    </node>
    <node concept="3_FBDc" id="4rqLd8XDi4H" role="3_Gd4Z">
      <property role="TrG5h" value="SM_States" />
      <node concept="3_FwNw" id="4rqLd8XDi5g" role="3_Fx_Q">
        <ref role="3_FwNB" node="73qKrKUOsUG" resolve="StateMachine" />
      </node>
      <node concept="2zC27e" id="4rqLd8XDi5j" role="3_Fx_f">
        <property role="3_FBD6" value="states" />
        <property role="2zC27X" value="1axOPyL0vaw/Set" />
        <ref role="3_FBDr" node="4rqLd8XDi0j" resolve="State" />
      </node>
    </node>
    <node concept="3_FBDc" id="4rqLd8XDi6R" role="3_Gd4Z">
      <property role="TrG5h" value="SM_Transitions" />
      <node concept="2zC0rd" id="4rqLd8XDi81" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmr/Containment" />
        <node concept="2zC6PY" id="4rqLd8XDi83" role="2zC0rK">
          <property role="3_FBD6" value="myStateMachine" />
          <ref role="2zC6PZ" node="73qKrKUOsUG" resolve="StateMachine" />
        </node>
      </node>
      <node concept="2zC27e" id="4rqLd8XDi87" role="3_Fx_f">
        <property role="3_FBD6" value="transitions" />
        <property role="2zC27X" value="1axOPyL0vaw/Set" />
        <ref role="3_FBDr" node="4rqLd8XDi5P" resolve="Transition" />
      </node>
    </node>
    <node concept="3_FBDc" id="4rqLd8XDi8a" role="3_Gd4Z">
      <property role="TrG5h" value="SM_events" />
      <node concept="3_FwNw" id="4rqLd8XDi8P" role="3_Fx_Q">
        <ref role="3_FwNB" node="73qKrKUOsUG" resolve="StateMachine" />
      </node>
      <node concept="2zC27e" id="4rqLd8XDi8S" role="3_Fx_f">
        <property role="3_FBD6" value="events" />
        <property role="2zC27X" value="1axOPyL0vaw/Set" />
        <ref role="3_FBDr" node="4rqLd8XDi2a" resolve="Event" />
      </node>
    </node>
    <node concept="3_FBDc" id="4rqLd8XDi9y" role="3_Gd4Z">
      <property role="TrG5h" value="TR_from" />
      <node concept="3_FwNw" id="4rqLd8XDiag" role="3_Fx_Q">
        <ref role="3_FwNB" node="4rqLd8XDi5P" resolve="Transition" />
      </node>
      <node concept="2zC27e" id="4rqLd8XDiaj" role="3_Fx_f">
        <property role="3_FBD6" value="from" />
        <ref role="3_FBDr" node="4rqLd8XDi0j" resolve="State" />
      </node>
    </node>
    <node concept="3_FBDc" id="4rqLd8XDib0" role="3_Gd4Z">
      <property role="TrG5h" value="TR_to" />
      <node concept="3_FwNw" id="4rqLd8XDibL" role="3_Fx_Q">
        <ref role="3_FwNB" node="4rqLd8XDi5P" resolve="Transition" />
      </node>
      <node concept="2zC27e" id="4rqLd8XDibO" role="3_Fx_f">
        <property role="3_FBD6" value="to" />
        <ref role="3_FBDr" node="4rqLd8XDi0j" resolve="State" />
      </node>
    </node>
    <node concept="3_FBDc" id="4rqLd8XDifW" role="3_Gd4Z">
      <property role="TrG5h" value="TR_event" />
      <node concept="3_FwNw" id="4rqLd8XDigK" role="3_Fx_Q">
        <ref role="3_FwNB" node="4rqLd8XDi5P" resolve="Transition" />
      </node>
      <node concept="2zC27e" id="4rqLd8XDigN" role="3_Fx_f">
        <property role="3_FBD6" value="event" />
        <ref role="3_FBDr" node="4rqLd8XDi2a" resolve="Event" />
      </node>
    </node>
  </node>
</model>

