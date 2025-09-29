// Another concrete class

public class GroceryTask implements Task{

    private String item;
    public GroceryTask(String item) {
        this.item = item;
    }

    @Override
    public void execute() {
        System.out.println("Buy Grocery Item: " + item);
    }
}
