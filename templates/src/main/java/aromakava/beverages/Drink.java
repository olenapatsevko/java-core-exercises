package aromakava.beverages;


public interface Drink {
    enum Size {BIG, MEDIUM, SMALL}


    String getDescription();

    void setSize(Size size);

    Size getSize();

    double cost();

    void setDescription(String description);

}
