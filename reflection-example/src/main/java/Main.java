import computer.Laptop;
import computer.Machine;
import proxy.CustomInvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
       static Logger logger = Logger.getAnonymousLogger();
        public static void main(String[]args) throws InvocationTargetException, IllegalAccessException {
            Laptop laptop = new Laptop();
          logger.log(Level.FINE, laptop.toString());

            Machine laptop1 = (Machine) Proxy.newProxyInstance(Laptop.class.getClassLoader(),Laptop.class.getInterfaces(), new CustomInvocationHandler(laptop) );
            logger.log(Level.FINE, ""+laptop1.getScreen());


            logger.fine( ""+12);



            try {
                Class<?> laptop1Class = Class.forName("computer.Laptop");
                logger.fine(laptop1Class.getTypeName());
            } catch (ClassNotFoundException e) {
                Logger.getAnonymousLogger().log(Level.FINE, e.getMessage());
            }

           Class <Laptop> laptop0Class = Laptop.class;
           logger.fine(laptop0Class.getTypeName());

            Class<? extends Laptop> laptopClass = laptop.getClass();
           logger.fine(laptopClass.getTypeName());

           Method []method =  laptop0Class.getMethods();
           for (int i =0 ; i<method.length; i++){
              logger.fine("Method name: "+ method[i].getName());
              logger.fine((((method[i].getAnnotations().length)>0)?"Annonations used:"+Arrays.toString( method[i].getAnnotations()):"No annotations found"));
              if (method[i].getAnnotations().length>0){

                  for (int j = 0 ; j<method[i].getAnnotations().length; j++  ){
                      if (method[i].getAnnotations()[j].annotationType().getSimpleName().equals("Call")){
                          method[i].invoke(laptop);
                      }
                  }
              }
              logger.fine("Method params:"+Arrays.toString(method[i].getParameterTypes()));


           }

          logger.fine("Package of the class is :"+laptop0Class.getPackage());
          logger.fine("Simple name of the class is: "+laptop0Class.getSimpleName());




        }
}
