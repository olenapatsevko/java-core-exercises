package aromakava.beverages;

public class Tea implements Drink {
    private Size size = Size.SMALL;
    private String description = "Tea";

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public double cost() {
        return 0.2;
    }
}
