import computer.Laptop;
import computer.Machine;
import junit.framework.TestCase;
import org.junit.Test;
import proxy.CustomInvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class LaptopTest extends TestCase {

    @Test
    public void testToString1() {
        Laptop laptop = new Laptop();
        assertEquals("Name: null processorFrequency:0 quantityOfKernel:0 computerDataStorage:0 Computer Memory:0 Screen:0.0 Weight:0.0 Battery:0.0", laptop.toString());

    }


    @Test
    public void testToString2() {
        Laptop laptop = new Laptop();

        Machine laptop1 = (Machine) Proxy.newProxyInstance(Laptop.class.getClassLoader(),Laptop.class.getInterfaces(), new CustomInvocationHandler(laptop) );
       // laptop1.setBattery(12);
        assertEquals( 0.,laptop1.getScreen() );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void setterTest(){
        Laptop laptop = new Laptop();
        Machine laptop1 = (Machine) Proxy.newProxyInstance(Laptop.class.getClassLoader(),Laptop.class.getInterfaces(), new CustomInvocationHandler(laptop) );
        laptop1.setBattery(12);
    }


    @Test
    public void testToString3() {
        Laptop laptop = new Laptop();
        Class <Laptop> laptop0Class = Laptop.class;
        // out.println(laptop0Class.getTypeName());
        Class<? extends Laptop> laptopClass = laptop.getClass();
        // out.println(laptopClass.getTypeName());
        assertEquals(laptop0Class.getCanonicalName(), laptopClass.getCanonicalName());
    }


}