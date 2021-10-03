package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;
import org.junit.jupiter.api.Test;

import commands.Command;
import generated.stateMachineService.*;
import generated.stateMachineService.commands.StateMachine_validate_Command;
import generated.stateMachineService.commands.initialise_Command;
import observation.Observer;

class StateMachineServiceTest implements Observer{
	private static StateMachineService theService;
	private StateMachine sm1, sm2; 
	private State z0,z1;
	private Event e0,e1;
// Test-Automaten einmalig zusammen bauen
// Events = {0,1}, Z = {z0, z1}, E = {z1}, delta(z0,0)=z1, delta(z1,1)=z1 	
	public StateMachineServiceTest(){
		this.constructSM1();
	}
	
	private void constructSM1() {
		z0 = State.createFresh(Optional.of("z0"), false);
		sm1 = StateMachine.createFresh(z0, "My State Machine");
		initialise_Command ic = new initialise_Command(z0, "My State Machine");
		z1 = State.createFresh(Optional.of("z1"), true);
		sm1.addToStates(z0);
		sm1.addToStates(z1);
		e0 = Event.createFresh("0");
		e1 = Event.createFresh("1");
		sm1.addToEvents(e0);
		sm1.addToEvents(e1);
		sm1.addTransition(z0, z1, e0);
		sm1.addTransition(z1, z1, e1);
	}

	@Test
	void test1() {
		assertTrue(sm1.validate("011"));
	}
	@Test
	void test2() {
		assertFalse(sm1.validate("11"));
	}
	@Test
	void test3() {
		assertFalse(sm1.validate(""));
	}
	@Test
	void test4() {
		assertTrue(sm1.validate("0"));
	}
	@Test
	void test5() {
		StateMachine_validate_Command smvc = new StateMachine_validate_Command(sm1, "0111");
		sm1.addObserver(this);
		smvc.execute(); // Im Kommando wird das Resultat vermerkt
		try {
			assertTrue(smvc.getResult());
		} catch (Exception e) {
			fail();		
		}
	}
	
/**	
 * A non-deterministic automaton
 * @throws PersistenceException 
 * @throws ConstraintViolation 
 */
	private void constructSM2(){
		sm2 = StateMachine.createFresh(z0, "NFA");
		sm2.addToStates(z0);
		sm2.addToStates(z1);
		sm2.addToEvents(e0);
		sm2.addToEvents(e1);
		sm2.addTransition(z0, z1, e0);
		sm2.addTransition(z1, z1, e1);
		sm2.addTransition(z0, z0, e0); // Thus it is a (real) NFA
	}

	public void update(Command<?> command) {
		System.out.println("Es ist ein " + command.getClass().getName() + "-Kommando ausgeführt worden");
	}
}