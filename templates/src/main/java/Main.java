import aromakava.beverages.Tea;
import aromakava.condiments.*;
import coffeefm.Cafeteria;
import coffeefm.GoldCafeteria;
import observer.CurrentConditionsDisplay;
import aromakava.beverages.Drink;

public class Main {

    public static void main(String[] args) {
        CondimentDecorator teaWithMilk = new Milk(
                new Cinnamon(
                        new Fruits( new Sugar(
                                new Tea()
                        ))));
        System.out.println(teaWithMilk.getDescription());


        Cafeteria cafeteria = new GoldCafeteria();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(cafeteria);

        Drink drink = cafeteria.orderDrink("Espresso");
        System.out.println("Client ordered a " + drink.getDescription() + "\n");

        drink = cafeteria.orderDrink("Double Tea");
        System.out.println("Client ordered a " + drink.getDescription() + "\n");

        drink = cafeteria.orderDrink("Latte");
        System.out.println("Client ordered a " + drink.getDescription() + "\n");
    }

}
