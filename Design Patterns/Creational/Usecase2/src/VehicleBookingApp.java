import java.util.Scanner;

// This is tha main class...here user will only give input and will not care about object creation
public class VehicleBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to vehicle Booking App ");
        System.out.print("Choose your ride (Car / Bike / Auto) : ");
        String choice = sc.nextLine();

        System.out.print("Enter distance in km: ");
        int distance = sc.nextInt();

        try {
            Transport ride = TransportFactory.getTransport(choice);
            ride.ride(distance);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
