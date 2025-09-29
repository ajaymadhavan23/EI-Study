// This is a decorator class used for Decorator concrete classes

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }


    @Override
    public String name() {
        return coffee.name();
    }

    @Override
    public int cost() {
        return coffee.cost();
    }
}
