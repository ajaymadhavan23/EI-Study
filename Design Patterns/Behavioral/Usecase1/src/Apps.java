// This is the base class to make different Observers like (apps: messenger, mail...etc.)

public class Apps implements Observer{

    private String displayname;
    public Apps(String displayname){
        this.displayname=displayname;
    }

    @Override
    public void update(String name, double price) {
        System.out.println(displayname+" received update: "+name+" is now: "+price);
    }
}
