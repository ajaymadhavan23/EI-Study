public class StockPriceAlert {
    public static void main(String[] args) {
        Stock apple = new Stock("Apple",50);
        Apps messenger = new Apps("Notification: ");
        Apps mail = new Apps("Email: ");

        apple.subscribe(messenger);
        apple.subscribe(mail);

        apple.setPrice(70);

        apple.unsubscribe(messenger);
        apple.setPrice(80);
    }
}
