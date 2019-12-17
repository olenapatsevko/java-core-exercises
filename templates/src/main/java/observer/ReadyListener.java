package observer;

import aromakava.beverages.Drink;

public class ReadyListener implements EventListener {
    int time;
    public ReadyListener(int time){
        this.time = time;
    }

    @Override
    public void update(String mess, Drink drink) {
        System.out.println(mess + drink.getDescription()+ drink.getSize());
    }
}
