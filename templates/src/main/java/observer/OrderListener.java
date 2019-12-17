package observer;

import aromakava.beverages.Drink;

public class OrderListener implements EventListener {
    private  int num;

    public OrderListener(int num){
        this.num = num;
    }


    @Override
    public void update(String mess, Drink drink) {
        System.out.println(mess+" " +num + drink.getDescription()+ drink.getSize());
    }
}
