package aromakava.condiments;

import aromakava.beverages.Drink;

public class Fruits extends CondimentDecorator {
	public Fruits(Drink drink) {
		super(drink);;
	}
 
	public String getDescription() {
		return super.getDescription() + ", fruits ";
	}
 
	public double cost() {
		return super.cost() + .10;
	}
}
