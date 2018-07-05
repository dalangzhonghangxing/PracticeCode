package desigin_pattern;

// 观察者模式的精髓是，装饰者与被装饰者都源于同一个父类
// 装饰者对父类方法的实现是基于被装饰者的，如DisCount的cost方法需要用到HotGoods的cost方法。
// 除了折扣，还有奶茶与珍珠、椰果；手抓饼与烤肠、鸡蛋等场景。
// 共同点是折扣、珍珠、椰果、烤肠、鸡蛋不会单卖，都需要依赖商品、奶茶、手抓饼，即在价格上对主要商品进行装饰。
public class 装饰者模式测试 {
    // 定义一个商品超类
    static abstract class Goods {
        String name;

        public abstract double cost();

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + "\t" + cost();
        }
    }

    // 定义折扣超类，是装饰者，装饰goods属性，同时因为折扣类也继承自Goods，因此装饰者也可以成为被装饰者。
    static abstract class DisCount extends Goods {
        Goods goods;
    }

    // 热卖商品鱼
    static class Fish extends Goods {
        public Fish() {
            name = "fish";
        }

        @Override
        public double cost() {
            return 10.0;
        }
    }

    // 热卖商品鸡
    static class Chicken extends Goods {
        public Chicken() {
            name = "chicken";
        }

        @Override
        public double cost() {
            return 15.0;
        }
    }

    // 八折
    static class EightCount extends DisCount {
        public EightCount(Goods goods) {
            name = goods.getName() + "打八折";
            this.goods = goods;
        }

        @Override
        public double cost() {
            return 0.8 * goods.cost();
        }
    }

    // 五折
    static class FiveCount extends DisCount {
        public FiveCount(Goods goods) {
            name = goods.getName() + "打五折";
            this.goods = goods;
        }

        @Override
        public double cost() {
            return 0.5 * goods.cost();
        }
    }

    public static void main(String[] args) {
        // 先输出原价商品
        Fish fish = new Fish();
        Chicken chicken = new Chicken();
        System.out.println(fish.toString());
        System.out.println(chicken.toString());

        // 打五折后的鱼
        FiveCount fc = new FiveCount(fish);
        System.out.println(fc.toString());

        // 打8折后的鸡
        EightCount ec = new EightCount(chicken);
        System.out.println(ec.toString());

        // 发福利，5折之后再打8折,即4折。这是装饰者变成被装饰者的典型
        FiveCount fourCount = new FiveCount(ec);
        System.out.println(fourCount.toString());
    }
}
