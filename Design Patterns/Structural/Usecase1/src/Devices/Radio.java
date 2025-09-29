package Devices;

public class Radio implements Device {

    private boolean on = false;
    private int volume;

    @Override
    public void poweron() {
        on = true;
        System.out.println("Radio power on");
    }

    @Override
    public void poweroff() {
        on = false;
        System.out.println("Radio power off");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Radio volume set to " + volume);
    }

    @Override
    public boolean ispoweron() {
        return on;
    }
}
