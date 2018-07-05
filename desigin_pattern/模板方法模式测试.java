package desigin_pattern;

/*
 * 模板方法模式一般用于流程处理，它能够定义一套流程的框架，然后由子类来实现每一个步骤具体的操作。
 * 通俗一点，就是父类定义一系列接口，并固定这些接口的调用次序；子类只能够细化每一步，无法改变（也不需要改变）这些步骤的执行次序。
 * 下面我们通过一个例子来感受一下： 我们要实现两个流程上大致一样的操作：烧一条红烧鱼、做一斤小龙虾。我们先抽象一下这两道菜的公共流程： 1. 杀死它们 2.
 * 把它们弄干净 3. 放入锅中，加佐料 4. 煮熟 好吧，毕竟是程序员，不要太注重做菜的细节。。。
 */
public class 模板方法模式测试 {
    // 首先定义一个模板，在实现这个抽象类的时候，对某些步骤可以给出默认的实现。
    static abstract class Template {
        // 先要杀死食材，毕竟活着煮熟太残忍。定义为抽象方法，子类必须实现这个方法。
        public abstract void kill();

        // 洗净食材，这里给出了一个默认的实现，因为大部分食材洗一下就好了。必要的话子类可以重写。
        public void clean() {
            System.out.println("洗干净");
        }

        // 放入锅中，同时加佐料。
        public abstract void inPot();

        // 开火煮
        public void fire() {
            System.out.println("开始煮...");
        }

        // 这是模板方法的灵魂，通过cooking方法，就能执行我们规定的流程，这也是“模板方法”名称的来源
        public final void cooking() {
            kill();
            clean();
            inPot();
            fire();
        }
    }

    // 下面我们实现Fish这个类，我们主要完善kill与inPot这两个方法，而不需要去考虑流程上的差异
    static class Fish extends Template {
        @Override
        public void kill() {
            System.out.println("用刀拍死");
            System.out.println("刮去鳞片");
            System.out.println("开肠破肚");
            System.out.println("挖出内脏");
        }

        @Override
        public void inPot() {
            System.out.println("把鱼放入锅中");
            System.out.println("加水");
            System.out.println("放入葱姜蒜");
            System.out.println("加黄酒");
        }
        
    }

    // 实现Lobster（小龙虾）类
    static class Lobster extends Template {
        @Override
        public void kill() {
            System.out.println("把头减掉");
            System.out.println("抽取虾线");
        }

        @Override
        public void inPot() {
            System.out.println("把龙虾放入锅中");
            System.out.println("加水");
            System.out.println("加各种料（由于料太多，我也不知道有哪些）");
        }
    }

    public static void main(String[] args) {
        Fish fish = new Fish();
        Lobster lobster = new Lobster();

        // 当使用了模板方法之后，我们在这里就不用去关心，烧鱼与煮小龙虾流程上面的不同，也不需要去考虑每一步要干嘛，
        // 只需要调用cooking方法即可。它将流程、每一步的具体实现、客户调用解耦。
        System.out.println("---------------烧条鱼-----------------");
        fish.cooking();
        System.out.println("-------------搞一斤小龙虾-----------------");
        lobster.cooking();
    }
}
