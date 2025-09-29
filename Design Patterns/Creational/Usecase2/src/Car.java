// Car mode of transport from the Transport interface

public class Car implements Transport {
    @Override
    public void ride(int distance) {
        int fair = distance*20;
        System.out.println("Car Booked, Distance: "+distance+" km, Fair: "+fair);
    }
}
