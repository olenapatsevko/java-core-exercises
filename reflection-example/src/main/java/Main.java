import computer.Computer;
import computer.Laptop;
import computer.Machine;
import proxy.CustomInvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Annotation;
import java.util.Arrays;
import static java.lang.System.out;
import static java.lang.System.setOut;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@SuppressWarnings("squid:S1872")
public class Main {

        public static void main(String[]args) throws InvocationTargetException, IllegalAccessException {
            Laptop laptop = new Laptop();
           out.println( laptop.toString());

            Machine laptop1 = (Machine) Proxy.newProxyInstance(Laptop.class.getClassLoader(),Laptop.class.getInterfaces(), new CustomInvocationHandler(laptop) );
           out.println( laptop1.getScreen());

       //  laptop1.setScreen(12.5);
        out.println(12);

           // laptop1.setScreen(12);

            try {
                Class<?> laptop1Class = Class.forName("computer.Laptop");
                out.println(laptop1Class.getTypeName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

           Class <Laptop> laptop0Class = Laptop.class;
           out.println(laptop0Class.getTypeName());

            Class<? extends Laptop> laptopClass = laptop.getClass();
            out.println(laptopClass.getTypeName());

           Method method[] =  laptop0Class.getMethods();
           for (int i =0 ; i<method.length; i++){
               out.println("Method name: "+ method[i].getName().toString());
               out.println((((method[i].getAnnotations().length)>0)?"Annonations used:"+Arrays.toString( method[i].getAnnotations()):"No annotations found"));
              if (method[i].getAnnotations().length>0){

                  for (int j = 0 ; j<method[i].getAnnotations().length; j++  ){
                      if (method[i].getAnnotations()[j].annotationType().getSimpleName().equals("Call")){
                          method[i].invoke(laptop);
                      }
                  }
              }
               out.println("Method params:"+Arrays.toString(method[i].getParameterTypes()));


           }

          out.println("Package of the class is :"+laptop0Class.getPackage());
          out.println("Simple name of the class is: "+laptop0Class.getSimpleName());




        }
}
