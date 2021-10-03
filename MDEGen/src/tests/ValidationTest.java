package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import commands.Command;
import commands.ObjectCommand;
import commands.ServiceCommand;
import db.connection.NoConnectionException;
import db.executer.DBConnectionManager;
import db.executer.PersistenceException;
import exceptions.ConstraintViolation;
import generated.validationFinal.*;
import generated.validationFinal.commands.validate_Command;
import generated.validationFinal.commands.stateMachine.StateMachine_isDeterministic_Command;

class ValidationTest{
	private static Connection conn; 
	private generated.validationFinal.StateMachine sm1, sm2; 
	private State z0,z1;
	private Event e0,e1;
// Test-Automaten einmalig zusammen bauen
// Events = {0,1}, Z = {z0, z1}, E = {z1}, delta(z0,0)=z1, delta(z1,1)=z1 	
// L = L(01*)	
	public ValidationTest() {
		try {
			this.constructSM1();
			this.constructSM2(); // Mit zusätzlicher Transition z0 -(0)-> z0, also NFA
		} catch (PersistenceException|ConstraintViolation e) {
			System.out.println("Constructor: " + e.getMessage());
		}
	}
	
	@BeforeAll
	public static void setUp() throws NoConnectionException{
		ValidationFinal.getInstance();
		conn = DBConnectionManager.getTheInstance().get();
	}
	@AfterAll
	public static void tearDown(){
		try {
			conn.createStatement().executeUpdate("DELETE FROM STATEMACHINE");
			conn.createStatement().executeUpdate("DELETE FROM STATE");
			conn.createStatement().executeUpdate("DELETE FROM EVENT");
			conn.createStatement().executeUpdate("DELETE FROM TRANSITION");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Tear Down: " + e.getMessage());
		}
		System.out.println("Tear Down beendet");
	}
/**	
 * A deterministic automaton
 * @throws PersistenceException 
 * @throws ConstraintViolation 
 */
	private void constructSM1() throws PersistenceException, ConstraintViolation {
		z0 = State.createFresh(Optional.of("z0"), false);
		sm1 = StateMachine.createFresh(z0);
		z1 = State.createFresh(Optional.of("z1"), true);
		sm1.addToStates(z0);
		sm1.addToStates(z1);
		e0 = Event.createFresh("0");
		e1 = Event.createFresh("1");
		Transition.createFresh(z0, z1, e0, sm1); // Also adds the transition to the container sm1 (by containmanet constraint)
		Transition.createFresh(z1, z1, e1, sm1);
	}
/**	
 * A non-deterministic automaton
 * @throws PersistenceException 
 * @throws ConstraintViolation 
 */
	private void constructSM2() throws PersistenceException, ConstraintViolation {
		sm2 = StateMachine.createFresh(z0);
		sm2.addToStates(z0);
		sm2.addToStates(z1);
		Transition.createFresh(z0, z1, e0, sm2);
		Transition.createFresh(z1, z1, e1, sm2);
		Transition.createFresh(z0, z0, e0, sm2);// Making it an NFA
	}
// Test mit 011
	@Test
	void test1() throws PersistenceException, NotValidException {
		ValidationFinal.getInstance().validate(sm1, "011");
	}
// Test mit 0
	@Test
	void test2() throws PersistenceException, NotValidException {
		ValidationFinal.getInstance().validate(sm1, "0");
	}
// Test mit leerem Wort
	@Test
	void test3() throws PersistenceException {
		try {
			ValidationFinal.getInstance().validate(sm1, "");
			fail("Exception not thrown");
		} catch (NotValidException e) {} // ok
	}
// Test mit 11
	@Test
	void test4() throws PersistenceException {
		try {
			ValidationFinal.getInstance().validate(sm1, "11");
			fail("Exception not thrown");
		} catch (NotValidException e) {} // ok
	}
	@Test
	void test5() throws PersistenceException {
		try {
			ValidationFinal.getInstance().validate(sm1, "000");
			fail("Not detercted");
		} catch (NotValidException e) {}
	}
	@Test
	void test6() throws PersistenceException {
		assertTrue(sm1.isDeterministic());
	}
	@Test
	void test7() throws PersistenceException {
		assertFalse(sm2.isDeterministic());
	}
	@Test
	void test8() throws PersistenceException {
		State z2 = State.createFresh(Optional.of("z2"), false);
		sm1.setStartState(z2);
		sm1.removeFromStates(z0);
		sm1.addToStates(z2);
		assertEquals(z2, sm1.getStartState());
		try {
			ValidationFinal.getInstance().validate(sm1, "0");
			fail("Exc not detected");
		} catch (NotValidException e) {} // ok
	}
	@Test
	void test9() throws PersistenceException, SQLException, ConstraintViolation, NoConnectionException {
		for (Transition tr : sm1.getTransitions()) {
			if(tr.getFrom().equals(z1)&&tr.getEvent().equals(e1)) Transition.delete(tr.getId());
		}
		assertEquals(1, sm1.getTransitions().size());
		ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM SM_TRANSITIONS WHERE p1 = " + sm1.getId());
		assertTrue(rs.next());
		assertEquals(1, rs.getInt(1));
	}
	@Test
	void test10a() throws PersistenceException, SQLException, NoConnectionException {
		assertEquals(2, sm1.getEvents().size());
		for (Event e : sm1.getEvents()) {
			if(e.getLabel().equals(e0.getLabel()))
				try {
					Event.delete(e.getId());
					fail("Deletion is not possible");
				} catch (ConstraintViolation e1) {} // ok
		}
	}
	@Test
	void test11() throws PersistenceException, SQLException {
		assertEquals(z0, sm1.getStartState());
		assertFalse(sm1.getStartState().getIsFinal());
		ResultSet rs = conn.createStatement().executeQuery("SELECT p2 FROM SM_STARTSTATE WHERE p1 = " + sm1.getId());
		rs.next();
		assertEquals(z0.getId(), rs.getInt(1));

		State z3 = State.createFresh(Optional.of("z3"), true);
		sm1.setStartState(z3);
		assertTrue(sm1.getStartState().getIsFinal());
		rs = conn.createStatement().executeQuery("SELECT p2 FROM SM_STARTSTATE WHERE p1 = " + sm1.getId());
		rs.next();
		assertEquals(z3.getId(), rs.getInt(1));
	}
	@Test
	void test12() throws Exception {
		Command<Void> c = new validate_Command(sm1, "01");
		c.execute();
		c.getResult();
		assertTrue(true); // We just must reach this point
	}
	@Test
	void test13(){
		ServiceCommand<Void> c = new validate_Command(sm1, "1");
		c.execute();
		try {
			c.getResult();
			fail("NotValidException not caught");
		} catch (Exception e) {} // ok
	}
	@Test
	void test14() throws Exception{
		ObjectCommand<StateMachine, Boolean> c = new StateMachine_isDeterministic_Command(sm1);
		c.execute();
		assertEquals(sm1, c.getReceiver());
		assertTrue(c.getResult());
	}
	@Test
	void test15() throws Exception{
		ObjectCommand<StateMachine, Boolean> c = new StateMachine_isDeterministic_Command(sm2);
		c.execute();
		assertEquals(sm2, c.getReceiver());
		assertFalse(c.getResult());
	}
}