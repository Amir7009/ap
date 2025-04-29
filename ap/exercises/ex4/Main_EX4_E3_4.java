package ap.exercises.ex4;

public class Main_EX4_E3_4 { // HallWayLamp

    private boolean switch1 = true, switch2 = true, lamp = true;

    public int getFirstSwitchState(){// 0 for down, 1 for up

        return switch1 ? 1 : 0;

    }

    public int getSecondSwitchState(){

        return switch2 ? 1 : 0;

    }

    public int getLampState() { // 0 for off, 1 for on

        return lamp ? 1 : 0;

    }

    public void toggleFirstSwitch(){

        switch1 = !switch1;
        lamp = !lamp;

    }
    public void toggleSecondSwitch(){

        switch2 = !switch2;
        lamp = !lamp;

    }

}