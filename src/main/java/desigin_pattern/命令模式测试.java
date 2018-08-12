package desigin_pattern;

// 命令模式能够封装一系列操作，然后对外给出一个统一的接口，如execute；
// 下面会模拟两组不同的操作
// 1. 开关灯
// 2. 煮饭——淘米、加水、放入锅子、开火
public class 命令模式测试 {
    static class Light {
        public void on() {
            System.out.println("开灯了");
        }

        public void off() {
            System.out.println("关灯了");
        }
    }

    static class Rice {

        public void clean() {
            System.out.println("淘米");
        }

        public void addWater() {
            System.out.println("加水");
        }

        public void inPot() {
            System.out.println("放入锅中");
        }

        public void fire() {
            System.out.println("开火");
        }
    }

    // 定义一个Command接口，它包含一个execute方法，子类通过该方法来实现各自的一组操作
    static interface Command {
        void execute();
    }

    // 用于封装Light的操作，开灯，过一秒后关灯
    static class LightCommand implements Command {
        Light light;

        public LightCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.on();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            light.off();
        }
    }

    // 实现煮饭操作——淘米、加水、放入锅子、开火
    static class RiceCommand implements Command {
        Rice rice;

        public RiceCommand(Rice rice) {
            this.rice = rice;
        }

        @Override
        public void execute() {
            rice.clean();
            rice.addWater();
            rice.inPot();
            rice.fire();
        }
    }

    public static void main(String[] args) {
        Light light = new Light();
        Rice rice = new Rice();
        LightCommand lc = new LightCommand(light);
        RiceCommand rc = new RiceCommand(rice);

        // 通过LightCommand与RiceCommand，能够屏蔽掉开关灯与煮饭本身细节，
        // 通过统一的execute就能够执行一系列不同的操作
        Command[] commands = { lc, rc };
        for (Command c : commands)
            c.execute();
    }
}
