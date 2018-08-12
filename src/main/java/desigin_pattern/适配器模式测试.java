package desigin_pattern;

// 适配器模式的主要作用是，将一个接口，转换成另一个接口。
// 说的在直白点，就是有两个名字、功能、属性、方法的不同的类，使得其中的一个，能通过适配器，能***看起来***像另一个
// 在java中，早起的Collection有一个elements()方法，通过枚举类来遍历集合集合中的所有元素；
// 但现在都用Iterator，为了避免之前用elements()方法的地方报错，因此可以使用适配器，使得之前的枚举类表现的与Iterator一样。
// 下面通过例子来看
public class 适配器模式测试 {
    static class Duck {
        // 鸭子会游泳
        public void swimming() {
            System.out.println("游泳");
        }

        // 鸭子叫起来是 嘎嘎嘎
        public void gaga() {
            System.out.println("嘎嘎嘎");
        }

    }

    static class Chicken {
        // 鸡叫起来是 咕咕咕
        public void gugu() {
            System.out.println("咕咕咕");
        }
    }

    // 鸭子适配器,使一只鸡看起来像鸭子，
    // 像的意思是，这个类的方法与鸭子是一样的
    static class DuckAdapter extends Duck {
        Chicken chicken;

        public DuckAdapter(Chicken chicken) {
            this.chicken = chicken;
        }

        // 鸡不会游泳，因此游泳的实现方式与鸭子不一样
        @Override
        public void swimming() {
            System.out.println("扑腾扑腾");
        }

        // 鸡只能发出咕咕咕的声音
        @Override
        public void gaga() {
            chicken.gugu();
        }
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        Chicken chicken = new Chicken();
        Duck fakeDuck = new DuckAdapter(chicken);
        System.out.println("---------真鸭子----------");
        duck.swimming();
        duck.gaga();
        System.out.println("---------真鸡------------");
        chicken.gugu();

        // 适配器可以将本不是duck的类，像duck一样调用
        System.out.println("---------假鸭子----------");
        fakeDuck.swimming();
        fakeDuck.gaga();
    }
}
