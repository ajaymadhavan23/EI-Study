// Another concrete DEcorator class

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String name() {
        return coffee.name()+" with chocolate";
    }

    @Override
    public int cost() {
        return coffee.cost()+10;
    }
}
