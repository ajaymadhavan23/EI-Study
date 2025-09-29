// This is one type of base coffee that implements Coffee interface

public class SimpleCoffee implements Coffee {
    @Override
    public String name() {
        return "Simple Coffee";
    }

    @Override
    public int cost() {
        return 10;
    }
}
