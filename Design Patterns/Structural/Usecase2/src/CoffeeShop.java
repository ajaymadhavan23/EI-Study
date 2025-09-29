public class CoffeeShop {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Coffee: "+coffee.name()+", Cost: "+coffee.cost());

        Coffee coffee2 = new Sugar(coffee);
        System.out.println("Coffee: "+coffee2.name()+", Cost: "+coffee2.cost());

        Coffee coffee3 = new Chocolate(coffee);
        System.out.println("Coffee: "+coffee3.name()+", Cost: "+coffee3.cost());
    }
}
