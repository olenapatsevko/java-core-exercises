package aromakava.condiments;

import aromakava.beverages.Drink;

public  class CondimentDecorator implements Drink {
	private Drink drink;


	public CondimentDecorator(Drink drink){
		this.drink = drink;
	}

	public  String getDescription(){
		return 	drink.getDescription();
	}

	@Override
	public void setSize(Size size) {
		drink.setSize(size);
	}

	public Size getSize() {
		return drink.getSize();
	}

	@Override
	public double cost() {
		return drink.cost();
	}

	@Override
	public void setDescription(String description) {
		drink.setDescription(description);

	}
}
