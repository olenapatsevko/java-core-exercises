package aromakava.condiments;

import aromakava.beverages.Drink;

public class Sugar extends CondimentDecorator {
	public Sugar(Drink drink) {
		super(drink);
	}
 
	public String getDescription() {
		return super.getDescription() + ", sugar";
	}
 
	public double cost() {
		return super.cost() + .20;
	}
}
