package desigin_pattern;

import java.util.ArrayList;
import java.util.List;

// 迭代器模式主要用于，对于数组、List、Set等记录多个元素的数据结构，给出一种统一的遍历方式。
// 大家不要因为有for(Object o:objects)这个for-each的语法糖的存在，
// 而认为这个模式没用，其实for-each正是使用了Iterator。
// 下面写一个简单的例子感受一下，当然为了突出Iterator，在这里也没用for-each。
public class 迭代器模式测试 {
    static class Something {
        String name;

        public Something(String name) {
            this.name = name;
        }
    }

    // 假如现在有三种不用的数据结构来存储Something

    // ----------------------------如果不同迭代器模式的代码是这样的--------------------
    // 第一种，基于数组的
    static class ArraySomething {
        Something[] array = new Something[3];
        int pos = 0;

        public void add(Something s) {
            if (pos < 10)
                array[pos++] = s;
            else
                System.out.println("满了");
        }

        public Something[] getAll() {
            return array;
        }
    }

    // 第二种，基于List的
    static class ListSomething {
        List<Something> list = new ArrayList<>();

        public void add(Something s) {
            list.add(s);
        }

        public List<Something> getAll() {
            return list;
        }
    }

    // 制造一批模拟数据
    static void init(ArraySomething as, ListSomething ls) {
        Something a = new Something("a");
        Something b = new Something("b");
        Something c = new Something("c");

        as.add(a);
        as.add(b);
        as.add(c);

        ls.add(a);
        ls.add(b);
        ls.add(c);
    }

    // 首先我们来看没用Iterator之前的写法。尽管代码段1、2非常相似，
    // 但是由于数组与list是两种不同的数据类型，因此无法将它们抽出来，假设又要加SetSomething，那又得改变这段代码。
    // 也就是说这段代码与ArraySomething、ListSomething、SetSomething的耦合度太高了。
    // 注意：在实际业务中，这段代码往往会出现在多个地方，一旦改变，维护起来相当麻烦。
    static void oldIterator() {
        ArraySomething as = new ArraySomething();
        ListSomething ls = new ListSomething();
        init(as, ls);

        // 1
        Something[] array = as.getAll();
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i].name);

        // 2
        List<Something> list = ls.getAll();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).name);
    }

    // ----------------------------用了迭代器模式的代码是这样的--------------------
    /*
     * 为了让遍历Something的代码能够适用任何数据类型，我们需要实现一个中间类——迭代器， 从而将对集合的遍历与数据类型解耦
     */

    // 先定义一个迭代器接口，java也提供了java.util.Iterator类。我这里为了大概演示下，remove方法就没加。
    // 在实际开发中，建议大家直接实现java.util.Iterator，毕竟这个通用的接口。
    static interface Iterator<T> {
        // 是否还有元素
        boolean hasNext();

        // 返回下一个元素
        T next();
    }

    // 为数组实现一个迭代器
    static class ArrayIterator implements Iterator<Something> {

        // 这个迭代器是为数组打造的，因此这里的类型是数组
        private Something[] somethings;
        private int pos = 0;// 记录当前遍历到的位置

        // 构造函数传入一个数组
        public ArrayIterator(Something[] somethings) {
            this.somethings = somethings;
        }

        // 按照数组的方式实现hasNext与next
        @Override
        public boolean hasNext() {
            if (pos >= somethings.length || somethings[pos] == null)
                return false;
            return true;
        }

        @Override
        public Something next() {
            return somethings[pos++];
        }
    }

    // 与ArrayIterator类似，实现ListIterator
    static class ListIterator implements Iterator<Something> {

        // 这里有所区别，数据类型变成了List
        private List<Something> somethingList;
        private int pos = 0;

        public ListIterator(List<Something> somethingList) {
            this.somethingList = somethingList;
        }

        // 按照list的方式实现hasNext与next
        @Override
        public boolean hasNext() {
            if (pos >= somethingList.size() || somethingList.get(pos) == null)
                return false;
            return true;
        }

        @Override
        public Something next() {
            return somethingList.get(pos++);
        }

    }

    // 为Something定义一个统一的集合接口
    static interface SomethingCollection {
        Iterator iterator();
    }

    // 然后我们修改下ArraySomething，使他基础自SomethingCollection
    // 大家可以去看java.util.Collection源码，里面也定义了Iterator接口
    static class ArraySomething2 implements SomethingCollection {
        Something[] array = new Something[10];
        int pos = 0;

        public void add(Something s) {
            if (pos < 10)
                array[pos++] = s;
            else
                System.out.println("满了");
        }

        // 然后我们注释掉原来的getAll方法，使用iterator方法代替，来返回一个统一的数据结构
        // 其实迭代器模式的奥秘就在这里，本来getAll返回的数据类型是各种各样的，有数组、list、set等等，
        // 但是现在变成了统一的Iterator，那么在进行遍历的时候，自然一套代码就搞定了
        // public Something[] getAll() {
        // return array;
        // }
        @Override
        public Iterator iterator() {
            return new ArrayIterator(this.array);
        }
    }

    // 修改ListSomething
    static class ListSomething2 implements SomethingCollection {
        List<Something> list = new ArrayList<>();

        public void add(Something s) {
            list.add(s);
        }

        // public List<Something> getAll() {
        // return list;
        // }
        @Override
        public Iterator iterator() {
            return new ListIterator(this.list);
        }
    }

    // 然后我们按照
    static void newIterator() {

        // 模拟数据
        ArraySomething2 as = new ArraySomething2();
        ListSomething2 ls = new ListSomething2();
        Something a = new Something("a");
        Something b = new Something("b");
        Something c = new Something("c");

        as.add(a);
        as.add(b);
        as.add(c);

        ls.add(a);
        ls.add(b);
        ls.add(c);

        // 业务中的代码，如果要加一个SetSomething，那修改起来轻而易举。
        // 如果要在遍历的时候改点逻辑，那可以直接改doIterator方法。
        doIterator(as.iterator());
        doIterator(ls.iterator());
    }

    // 将遍历抽出来，无论是什么数据类型的集合，已经与这段代码无关了
    // 换句话说，这段代码与SomethingCollection的数据类型解耦了，
    static void doIterator(Iterator<Something> iterator) {
        while (iterator.hasNext())
            System.out.println(iterator.next().name);
    }

    public static void main(String[] args) {
        System.out.println("------------------old---------------");
        oldIterator();

        System.out.println("------------------new---------------");
        newIterator();
    }

}
