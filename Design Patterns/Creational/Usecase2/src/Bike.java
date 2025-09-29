// Bike mode of transport from the Transport interface

public class Bike implements Transport {
    @Override
    public void ride(int distance) {
        int fare = distance*10;
        System.out.println("Bike Booked, Distance: "+distance+" km, Fair: "+fare);
    }
}
