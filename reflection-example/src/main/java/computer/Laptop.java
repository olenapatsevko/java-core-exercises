package computer;

import lombok.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
@EqualsAndHashCode(callSuper=false)
public class Laptop extends Computer implements Machine{


    private double screen;
    private double weight;
    private double battery;


    public Laptop(){
            super();

    }

    @Override
    public String toString() {
        return "Name: "+this.getName()+" processorFrequency:" + this.getProcessorFrequency()
                +" quantityOfKernel:"+ this.getQuantityOfKernel()+" computerDataStorage:"+this.getComputerDataStorage()+
                " Computer Memory:"+this.getComputerMemory()+" Screen:"+this.getScreen()+
                " Weight:"+this.getWeight()+" Battery:"+this.getBattery();
    }

    @Call
    public void increment(){
        Logger.getAnonymousLogger().log(Level.FINE,"\"invoking a method with my annotation\"");

        this.setScreen(this.getScreen()+1);
    }

    public String getPackage(){
        return Laptop.class.getCanonicalName();
    }



}
