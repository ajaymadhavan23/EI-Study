// Concrete subject...(Stocks) are the thing that we are gonna observe here

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private String name;
    private double price;
    private List<Observer> observers;

    public Stock(String name,double price){
        this.name=name;
        this.price=price;
        observers=new ArrayList<Observer>();
    }

    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observers){
            o.update(name,price);
        }
    }

    public void setPrice(double price){
        this.price=price;
        System.out.println("Price set to: "+price);
        notifyObservers();
    }
}
