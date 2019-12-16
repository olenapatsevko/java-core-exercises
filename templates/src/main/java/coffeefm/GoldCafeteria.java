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
                return new Espresso();
            case "Double Tea":
                return new Fruits(new Sugar(new Sugar(new Tea())));
            case "Latte":
                return new Milk(new Sugar(new Cinnamon(new Espresso()) {{ //NOSONAR
                    setSize(Size.MEDIUM);
                }}));
            default:
                return null;
        }
    }
}
