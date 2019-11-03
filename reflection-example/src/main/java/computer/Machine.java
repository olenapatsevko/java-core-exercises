package computer;

public interface Machine {

    void increment();
    String getName();
    int getComputerMemory();
    int getQuantityOfKernel();
    int getProcessorFrequency();
    int getComputerDataStorage();
    double getScreen();
    double getBattery();
    double getWeight();
    void setName(String s);
    void setComputerMemory(int computerMemory);
    void setQuantityOfKernel(int quantityOfKernel);
    void setProcessorFrequency(int processorFrequency);
    void setComputerDataStorage(int computerDataStorage);
    void setScreen(double screen);
    void setBattery(double battery);
    void setWeight(double weight);


}
