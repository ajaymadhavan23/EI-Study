package Devices;

public class Tv implements Device {

    private boolean on = false;
    private int volume;

    @Override
    public void poweron() {
        on = true;
        System.out.println("Power on");
    }
    @Override
    public void poweroff() {
        on = false;
        System.out.println("Power off");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume set to " + volume);
    }

    @Override
    public boolean ispoweron() {
        return on;
    }
}
