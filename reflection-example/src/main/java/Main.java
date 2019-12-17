import computer.Laptop;
import computer.Machine;
import lombok.extern.log4j.Log4j2;
import proxy.CustomInvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import static java.lang.System.out;

@Log4j2
@SuppressWarnings("squid:S1872")
public class Main {

        public static void main(String[]args) throws InvocationTargetException, IllegalAccessException {
            Laptop laptop = new Laptop();
           log.info( laptop.toString());

            Machine laptop1 = (Machine) Proxy.newProxyInstance(Laptop.class.getClassLoader(),Laptop.class.getInterfaces(), new CustomInvocationHandler(laptop) );
           log.info( laptop1.getScreen());


        out.println(12);


            try {
                Class<?> laptop1Class = Class.forName("computer.Laptop");
                out.println(laptop1Class.getTypeName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

           Class <Laptop> laptop0Class = Laptop.class;
           out.println(laptop0Class.getTypeName());

            Class<? extends Laptop> laptopClass = laptop.getClass();
           log.info(laptopClass.getTypeName());

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
               log.info("Method params:"+Arrays.toString(method[i].getParameterTypes()));


           }

          log.info("Package of the class is :"+laptop0Class.getPackage());
          log.info("Simple name of the class is: "+laptop0Class.getSimpleName());




        }
}
