package coffeefm;

import aromakava.beverages.Drink;
import aromakava.beverages.Espresso;
import aromakava.beverages.Tea;
import aromakava.condiments.Milk;
import aromakava.condiments.Sugar;
import aromakava.condiments.Cinnamon;
import aromakava.condiments.Fruits;

public class GoldCafeteria extends Cafeteria {

    Drink makeDrink(String item) {
        switch (item) {
            case "Espresso":
                Espresso espresso = new Espresso();
                events.notify("ready", espresso);
                return espresso;

            case "Double Tea":
                Drink drink =  new Fruits(new Sugar(new Sugar(new Tea()))) ;
                events.notify("ready", drink);
                return drink;

            case "Latte":
                Drink drink1 = new Milk(new Sugar(new Cinnamon(new Espresso()) {{ //NOSONAR
                    setSize(Size.MEDIUM);
                }}));
                events.notify("ready", drink1);
                return drink1;
            default:
                return null;
        }
    }
}
