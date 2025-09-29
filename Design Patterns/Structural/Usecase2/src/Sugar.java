// This is one of the Decorator concrete class

public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String name() {
        return coffee.name()+" with sugar";
    }

    @Override
    public int cost() {
        return coffee.cost()+5;
    }
}
