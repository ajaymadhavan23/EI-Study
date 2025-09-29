public class TransportFactory {
    // Factory method

    // This method will create object as per the user need...and return it
    public static Transport getTransport(String type) {
        if (type == null) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "auto":
                return new Auto();
            default:
                throw new IllegalArgumentException("Invalid transport type: " + type);
        }
    }
}
