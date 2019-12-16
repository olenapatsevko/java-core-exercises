package coffeefm;

import java.util.Observable;

import aromakava.beverages.Drink;



public abstract class Cafeteria extends Observable {

    abstract Drink makeDrink(String item);

    public Drink orderDrink(String type) {
        Drink drink = makeDrink(type);
        notifyThatDrinkIsBeingPrepared();
        return drink;
    }

    //////obsrv/////
    public void notifyThatDrinkIsBeingPrepared() {
        setChanged();
        notifyObservers();
    }
}
