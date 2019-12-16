package aromakava.beverages;

public class Espresso implements Drink {
private   Size size = Size.MEDIUM;
  private String description;
	public Espresso() {
		this.setDescription("Espresso");
	}

	@Override
	public String getDescription() {
		return format(description);
	}

	@Override
	public void setSize(Size size) {
		this.size = size;

	}

	@Override
	public Size getSize() {
		return this.size;
	}

	public double cost() {
		return 3.99;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;

	}

	private String  format(String s){
		return "\n$"+s+"$";
	}
}

