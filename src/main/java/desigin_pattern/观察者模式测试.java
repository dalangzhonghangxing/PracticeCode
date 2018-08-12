package desigin_pattern;

import java.util.ArrayList;
import java.util.List;

public class 观察者模式测试 {
    static class MySubject implements Subject {
        // 一般我们会定义一个List来存放所有的Observer
        List<Observer> observers = new ArrayList<>();

        private int i;

        public MySubject() {}

        // 注册一个observer
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        // 从observer列表中删除一个observer
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        // 触发从observer列表中每个observer的update方法,这些update的方法的参数往往都是一样的
        public void notifyObservers() {
            for (Observer observer : observers)
                observer.update(i);
        }

        public void doSomething() {
            i = 10;
            notifyObservers();
        }
    }

    static class MyObserver1 implements Observer {
        public MyObserver1() {}

        public void update(int i) {
            System.out.println("observer1：" + i);
        }
    }

    static class MyObserver2 implements Observer {
        public MyObserver2(){}

        public void update(int i) {
            System.out.println("observer2：" + (i * i));
        }
    }

    public static void main(String[] args) {
        MyObserver1 o1 = new MyObserver1();
        MyObserver2 o2 = new MyObserver2();
        MySubject s = new MySubject();
        s.registerObserver(o1);
        s.registerObserver(o2);
        s.doSomething();
    }
}
