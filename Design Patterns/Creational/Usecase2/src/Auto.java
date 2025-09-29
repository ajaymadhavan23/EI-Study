// Auto mode of transport from the Transport interface

public class Auto implements Transport{
    @Override
    public void ride(int distance) {
        int fare = distance*15;
        System.out.println("Auto Booked, Distance: "+distance+" km, Fair: "+fare);
    }
}
