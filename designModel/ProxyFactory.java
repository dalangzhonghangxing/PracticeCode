package designModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method,
                            Object[] args) throws Throwable {
                        System.out.println("--------begin-----------");
                        method.invoke(proxy, args);
                        System.out.println("--------end-------------");
                        return null;
                    }
                });
    }
    
//    static interface inter{
//        public int print();
//    }
//    
//    static class TestClass implements inter{
//        public int print(){
//            System.out.println("do something...");
//            return 0;
//        }
//    }
    
    public static void main(String[] args) {
        inter t = new TestClass();
        inter proxy = (inter) new ProxyFactory(t).getProxyInstance();
        proxy.print();
    }

}
