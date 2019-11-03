package computer;

import lombok.*;
import lombok.experimental.Tolerate;

import java.lang.annotation.Target;

@Data
@EqualsAndHashCode(callSuper=false)
public class Laptop extends Computer implements Machine{


    private double screen;
    private double weight;
    private double battery;


    public Laptop(){
            super();
        //    System.out.println("computer.Laptop Constructor");;
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
        System.out.println("invoking a method with my annotation" +
                "");
        this.setScreen(this.getScreen()+1);
    }

    public String getPackage(){
        String pack = Laptop.class.getCanonicalName();
        return pack;
    }



}
