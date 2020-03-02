import computer.Laptop;
import computer.Machine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import proxy.CustomInvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LaptopTest {

    @Test
    public void laptopToStringSuccessTest() {
        Laptop laptop = new Laptop();
        assertEquals("Name: null processorFrequency:0 quantityOfKernel:0 computerDataStorage:0 Computer Memory:0 Screen:0.0 Weight:0.0 Battery:0.0", laptop.toString());

    }


    @Test
    public void proxyCreationTest() {
        Laptop laptop = new Laptop();

        Machine laptop1 = (Machine) Proxy.newProxyInstance(Laptop.class.getClassLoader(), Laptop.class.getInterfaces(), new CustomInvocationHandler(laptop));
        // laptop1.setBattery(12);
        assertEquals(0., laptop1.getScreen(),0.01);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void proxySetterTestThrowsException() {
        Laptop laptop = new Laptop();
        Machine laptop1 = (Machine) Proxy.newProxyInstance(Laptop.class.getClassLoader(), Laptop.class.getInterfaces(), new CustomInvocationHandler(laptop));
        laptop1.setBattery(12);
    }


    @Test
    public void reflectionCanonicalTestEquality() {
        Laptop laptop = new Laptop();
        Class<Laptop> laptop0Class = Laptop.class;
        // out.println(laptop0Class.getTypeName());
        Class<? extends Laptop> laptopClass = laptop.getClass();
        // out.println(laptopClass.getTypeName());
        assertEquals(laptop0Class.getCanonicalName(), laptopClass.getCanonicalName());
    }


}