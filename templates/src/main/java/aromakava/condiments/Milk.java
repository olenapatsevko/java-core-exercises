package aromakava.condiments;

import aromakava.beverages.Drink;

public class Milk extends CondimentDecorator {
	public Milk(Drink drink) {
		super(drink);
	}

	public String getDescription() {
		return super.getDescription() + ", Milk";
	}

	public double cost() {
		return super.cost() + .10;
	}
}
