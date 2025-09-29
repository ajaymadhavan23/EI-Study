package Remotes;

import Devices.Device;

public abstract class Remote {

    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public abstract void togglepower();
    public abstract void volumeUp();
    public abstract void volumeDown();
}
