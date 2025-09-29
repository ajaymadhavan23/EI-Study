import Devices.Radio;
import Devices.Tv;
import Remotes.AdvanceRemote;
import Remotes.SimpleRemote;

public class Main {
    public static void main(String[] args) {
        System.out.println("Simple TV remote: ");
        SimpleRemote r1 = new SimpleRemote(new Tv());
        r1.togglepower();
        r1.volumeUp();
        r1.volumeDown();
        r1.togglepower();

        System.out.println();

        System.out.println("Advance TV remote: ");
        AdvanceRemote ar = new AdvanceRemote(new Tv());
        ar.togglepower();
        ar.volumeUp();
        ar.volumeDown();
        ar.mute();
        ar.togglepower();

        System.out.println();

        System.out.println("Advance Devices.Radio remote: ");
        AdvanceRemote ar2 = new AdvanceRemote(new Radio());
        ar2.togglepower();
        ar2.volumeUp();
        ar2.volumeDown();
        ar2.mute();
        ar2.togglepower();
    }
}
