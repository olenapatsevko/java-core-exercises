package computer;

import lombok.*;

@Data
public abstract class Computer  {



    private String name;
    private int processorFrequency;
    private  int quantityOfKernel;
    private int computerDataStorage;
    private int computerMemory;

    public Computer(){

    }

    @Override
    public abstract String toString();
}

