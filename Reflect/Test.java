package Reflect;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) {
        try {
            Object p = Class.forName("Reflect.P").newInstance();
            Class[] types = {String.class};
            Class.forName("Reflect.P").getClass()
             .getMethod("getName", types).invoke(p, "aaaa");
            // System.out.println(Class.forName("Reflect.P").getClass()
            // .getMethod("getName", null).invoke(p, null).toString());
//            System.out.println(p.getName());
        }
        catch (IllegalAccessException | IllegalArgumentException
                | SecurityException | ClassNotFoundException
                | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // System.out.println(p.getName());
    }
}
