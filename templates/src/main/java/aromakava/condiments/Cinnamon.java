package aromakava.condiments;

import aromakava.beverages.Drink;

public class Cinnamon extends CondimentDecorator {
	public Cinnamon(Drink tea) {
		super( tea);
	}

	public String getDescription() {
		return super.getDescription() + ", cinnamon";
	}

	public double cost() {
		double cost = super.cost();
		if (super.getSize() == Size.SMALL) {
			cost += .10;
		} else if (super.getSize() == Size.MEDIUM) {
			cost += .15;
		} else if (super.getSize() == Size.BIG) {
			cost += .20;
		}
		return cost;
	}
}
