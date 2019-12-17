package observer;

import aromakava.beverages.Drink;

public interface EventListener {

    void update(String mess , Drink drink);
}
