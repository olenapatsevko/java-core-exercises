package coffeefm;

import java.util.Observable;

import aromakava.beverages.Drink;
import observer.EventManager;


public abstract class Cafeteria  {
    public EventManager events;
    private Drink drink;
    public Cafeteria() {
        this.events = new EventManager("order", "ready");
    }


    abstract Drink makeDrink(String item);

    public Drink orderDrink(String type) {
        Drink drink = makeDrink(type);
        events.notify("order", drink);
        return drink;
    }



}
