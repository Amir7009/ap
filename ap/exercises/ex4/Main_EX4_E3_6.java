package ap.exercises.ex4;

public class Main_EX4_E3_6 { // HallWayLamp2

    private boolean[] switches = new boolean[]{true, true};
    private boolean lamp = true;

    public int getSwitchState(int switchNum) {

        return switches[switchNum-1] ? 1 : 0;

    }

    public int getLampState(){

        return lamp ? 1 : 0;

    }

    public void toggleSwitch(int switchNum){

        switches[switchNum-1] = !switches[switchNum-1];
        lamp = !lamp;

    }

}
