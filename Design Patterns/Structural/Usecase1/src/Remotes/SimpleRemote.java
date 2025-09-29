package Remotes;

import Devices.Device;

public class SimpleRemote extends Remote {
    public SimpleRemote(Device device) {
        super(device);
    }

    @Override
    public void togglepower() {
        if(device.ispoweron()) {
            device.poweroff();
        }
        else {
            device.poweron();
        }
    }

    @Override
    public void volumeUp() {
        device.setVolume(50);
    }

    @Override
    public void volumeDown() {
        device.setVolume(30);
    }
}
