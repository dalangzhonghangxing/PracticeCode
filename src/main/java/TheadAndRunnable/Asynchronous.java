package TheadAndRunnable;

public class Asynchronous {
    interface Callback {
        public void process(Object object);
    }

    class MyCallback implements Callback {
        @Override
        public void process(Object object) {
            System.out.println("Response status:" + object.toString());
        }

    }

    class Server {
        public void getMsg(Callback callback, Object msg) {
            System.out.println("Server get msg : " + msg.toString());
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Server processing finish!");
            callback.process("200");
        }
    }

    class Client {
        Server server;

        public Client(Server server) {
            this.server = server;
        }

        public void sendMsg(String msg) {
            System.out.println("Client sending msg...");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    server.getMsg(new MyCallback(), msg);
                }
            }).start();
            System.out.println("Send the msg!");
        }
    }

    public void test() {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("hello");
    }

    public static void main(String[] args) {
        new Asynchronous().test();
    }
}
