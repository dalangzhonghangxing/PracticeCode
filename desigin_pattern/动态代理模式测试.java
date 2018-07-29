//package desigin_pattern;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//// 前面我们已经看过了静态代理，看到了它的优点，同时也看到了它的缺点——需要依赖接口
//// 之前也说了，动态代理能够解决依赖接口这个缺点，但实际上动态代理也分两种
//// 1. JDK的动态代理（被代理类需要依赖接口，代理类不需要）
//// 2.Cglib提供的动态代理（通过子类的方式实现动态代理，完全不需要依赖接口），但是需要第三方库。注意由于是通过子类的方式实现代理，因此final类型的类无法通过该方式实现动态代理。
//// 目前Cglib被各种框架使用，如Spring
//public class 动态代理模式测试 {
//    // ----------------------1. JDK的动态代理------------------------------//
//    // 首先定义一个接口，供被代理类实现
//    static interface Action {
//        void doSomething();
//    }
//
//    // 被代理类
//    static class ActionImpl implements Action {
//        @Override
//        public void doSomething() {
//            System.out.println("I am doing something...");
//        }
//    }
//
//    // 代理类，现在已经不实习Action接口了，算是一种进步哦！
//    static class ActionoProxy {
//        // 需要将被代理类传进来
//        Action target;
//
//        public ActionoProxy(Action target) {
//            this.target = target;
//        }
//
//        // 生成代理对象，我们通过java.lang.reflect.Proxy.newProxyInstance方法来生成代理对象
//        public Action getProxyInstance() {
//            return (Action) Proxy.newProxyInstance(
//                    target.getClass().getClassLoader(), // 需要提供生成代理对象的ClassLoader，一般用target的ClassLoader
//                    target.getClass().getInterfaces(), // 需要提供target的接口，因此target一定要实现某个接口
//                    new InvocationHandler() {// 这里是核心——代理方法，通过这个方法实现代理
//                        @Override
//                        public Object invoke(Object proxy, Method method,
//                                Object[] args) throws Throwable {
//                            System.out.println("before doing something");
//
//                            // 通过反射来调用代理方法
//                            method.invoke(target, args);
//
//                            System.out.println("after doing something");
//
//                            // 方法的返回值，如果代理方法的返回值为void就返回null
//                            return null;
//                        }
//                    });
//        }
//    }
//
//    // 用于测试JDK的动态代理
//    public static void testJDKProxy() {
//        // 分别输出target.getClass()和proxyInstance.getClass()，
//        // 能够发现proxyInstance的类名为Proxy0，它是JDK在内存中生成的代理对象
//        Action target = new ActionImpl();
//        System.out.println(target.getClass());
//
//        Action proxyInstance = new ActionoProxy(target).getProxyInstance();
//        System.out.println(proxyInstance.getClass());
//
//        proxyInstance.doSomething();
//    }
//
//    // ----------------------2. Cglib的动态代理------------------------------//
//
//    // 定义一个代理工厂，用于为被代理类生成子类对象
//    static class ProxyFactory implements MethodInterceptor {
//
//        private Object target;
//
//        public ProxyFactory(Object target) {
//            this.target = target;
//        }
//
//        public Object getProxyInstance() {
//            // Cglib主要是通过这个Enhancer来创健子类
//            Enhancer enhancer = new Enhancer();
//
//            // 这里是与JDK动态的代理的一大区别，这里没有使用接口，而是通过父类的方式来与被代理类建立连接
//            enhancer.setSuperclass(target.getClass());
//            enhancer.setCallback(this);
//            return enhancer.create();
//        }
//
//        // 通过这个方法来实现代理，这个方法与JDK动态代理的InvocationHandler.invoke一模一样
//        @Override
//        public Object intercept(Object obj, Method method, Object[] args,
//                MethodProxy proxy) throws Throwable {
//            System.out.println("before doing something");
//
//            // 通过反射来调用代理方法
//            method.invoke(target, args);
//
//            System.out.println("after doing something");
//
//            // 方法的返回值，如果代理方法的返回值为void就返回null
//            return null;
//        }
//
//    }
//
//    static class MyAction {
//        public void doSomething() {
//            System.out.println("I am doing something...");
//        }
//    }
//
//    // 测试Cglib的代理方法
//    public static void testCglibProxy() {
//        MyAction target = new MyAction();
//        System.out.println(target.getClass());
//
//        MyAction proxyInstance = (MyAction) new ProxyFactory(target)
//                .getProxyInstance();
//        // 输出MyAction$$EnhancerByCGLIB$$d573c5b2,可以看到生成的proxyInstance是MyAction的子类
//        System.out.println(proxyInstance.getClass());
//
//        proxyInstance.doSomething();
//    }
//
//    public static void main(String[] args) {
//        System.out.println("---------------JDK动态代理---------------");
//        testJDKProxy();
//        System.out.println("---------------Cglib动态代理---------------");
//        testCglibProxy();
//    }
//}
