package generated.stateMachineService;

import java.util.Optional;

import exceptions.ConstraintViolation;

public class Main {

	public static void main(String[] args) {
	//Einfacher Test der Methode initialise
		StateMachineService.getInstance().initialise(State.createFresh(Optional.empty(), false), "SM1");
	//Ermitteln aller erzeugten StateMachine-Objekte und Ausgabe der Namen
		StateMachineService.getInstance().getStateMachineCache().values().forEach(s->System.out.println(s.getName()));
	//Analog Ermitteln aller bisher erzeugten State-Objekte
		StateMachineService.getInstance().getStateCache().values().forEach(s->System.out.println(s.getName()));
	}

	private static void test1() {
		//Generelles HAndling des generierten Codes
		State z0 = State.createFresh(Optional.of("z0"), false);
		StateMachine sm1 = StateMachine.createFresh(z0, "SM1");
		Event event = Event.createFresh("0");
		Transition transition = Transition.createFresh(z0, z0, event, sm1);
		System.out.println(sm1.getTransitions().size());
		
		StateMachine sm2 = StateMachine.createFresh(z0, "SM2");
		try {
			sm2.addToTransitions(transition); //geht nicht, weil trs schon in sm1 contained
		}catch (ConstraintViolation e) {
			System.out.println("Fehler " + e.getMessage());
		}
		System.out.println(sm1.getTransitions().size());
	}
	
}
