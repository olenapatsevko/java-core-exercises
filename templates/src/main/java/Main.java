import aromakava.beverages.Tea;
import aromakava.condiments.*;
import coffeefm.Cafeteria;
import coffeefm.GoldCafeteria;
import aromakava.beverages.Drink;
import observer.OrderListener;
import observer.ReadyListener;

import java.util.logging.Logger;


public class Main {
static Logger log =Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        CondimentDecorator teaWithMilk = new Milk(
                new Cinnamon(
                        new Fruits( new Sugar(
                                new Tea()
                        ))));
        log.info(teaWithMilk.getDescription());




        Cafeteria cafeteria = new GoldCafeteria();
      cafeteria.events.subscribe("order", new OrderListener(12));
      cafeteria.events.subscribe("ready", new ReadyListener(2));

        Drink drink = cafeteria.orderDrink("Espresso");
       log.info("Client ordered a " + drink.getDescription() + "\n");

        drink = cafeteria.orderDrink("Double Tea");
       log.info("Client ordered a " + drink.getDescription() + "\n");

        drink = cafeteria.orderDrink("Latte");
        log.info("Client ordered a " + drink.getDescription() + "\n");


    }

}
