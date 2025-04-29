package ap.exercises.ex4;

public class Main_EX4_E3_5 {

    public static void main(String[] args) { //CircuitTester

        Main_EX4_E3_4 lamp = new Main_EX4_E3_4(); // Object from HallWayLamp class
        showStates(lamp);
        lamp.toggleFirstSwitch();
        showStates(lamp);
        lamp.toggleSecondSwitch();
        showStates(lamp);
        lamp.toggleFirstSwitch();
        showStates(lamp);

    }

    public static void showStates ( Main_EX4_E3_4 lamp ){

        System.out.print("\nswitch 1: " + lamp.getFirstSwitchState() );
        System.out.print("\t\tswitch 2: " + lamp.getSecondSwitchState());
        System.out.println("\t\t\tlamp: " + lamp.getLampState());

    }

}
