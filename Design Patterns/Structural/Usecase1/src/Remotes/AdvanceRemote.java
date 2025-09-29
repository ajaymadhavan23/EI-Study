package Remotes;

import Devices.Device;

public class AdvanceRemote extends Remote {

    public AdvanceRemote(Device device) {
        super(device);
    }

    @Override
    public void togglepower() {
        if(device.ispoweron()) {
            device.poweroff();
        } else {
            device.poweron();
        }
    }

    @Override
    public void volumeUp() {
        device.setVolume(70);
    }

    @Override
    public void volumeDown() {
        device.setVolume(35);
    }

    // Because this is Advance lets have a new feature for it
    public void mute(){
        device.setVolume(0);
        System.out.println("muted");
    }
}
