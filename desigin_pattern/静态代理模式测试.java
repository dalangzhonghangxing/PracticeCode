package desigin_pattern;

// 静态代理即，代理类与被代理类都实现一个统一的接口，或继承相同的父类
// 静态代理能够在不修改被代理类的情况下，对其功能进行扩展。
// 但是因为要依赖接口，如果项目中希望通过代理的方式来实现日志记录，那岂不是每个类都要定义一个接口？
public class 静态代理模式测试 {
    // 首先定义一个接口，供代理类与被代理类实现
    static interface Action {
        void doSomething();
    }

    // 被代理类
    static class ActionImpl implements Action {
        @Override
        public void doSomething() {
            System.out.println("I am doing something...");
        }
    }

    // 代理类
    static class ActionoProxy implements Action {
        // 需要将被代理类传进来
        Action action;

        public ActionoProxy(Action action) {
            this.action = action;
        }

        @Override
        public void doSomething() {
            // 在执行action.doSomething()的前后，可以执行一些其它的操作，比如编码转换、记录日志、事物的开启关闭等等
            System.out.println("before doing something");
            action.doSomething();
            System.out.println("after doing something");
        }
    }

    public static void main(String[] args) {
        Action target = new ActionImpl();
        ActionoProxy ap = new ActionoProxy(target);
        ap.doSomething();
    }
}
