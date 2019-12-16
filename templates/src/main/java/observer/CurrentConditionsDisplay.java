package observer;

import java.util.Observable;
import java.util.Observer;

import coffeefm.Cafeteria;


public class CurrentConditionsDisplay implements Observer {

	Observable observable;
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof Cafeteria) {

			System.out.println("OBSERVED: was prepared");
			display();
		}
	}
	
	public void display() {
	}
}
