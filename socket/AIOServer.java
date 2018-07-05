package socket;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

public class AIOServer {
    AsynchronousServerSocketChannel server = null;

    public AIOServer() {
        try {

            server = AsynchronousServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(
                    "localhost", 7000);
            server.bind(inetSocketAddress);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("server listen on " + 7000);
    }

    public static void main(String[] arges) throws Exception {
        new AIOServer().start();
        while (true) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        server.accept("attatchment",
                new CompletionHandler<AsynchronousSocketChannel, Object>() {

                    final ByteBuffer buffer = ByteBuffer.allocate(1024);

                    @Override
                    public void completed(AsynchronousSocketChannel result,
                            Object attachment) {
                        System.out.println(Thread.currentThread().getName());
                        Future<Integer> f = null;
                        try {
                            buffer.clear();
                            result.read(buffer).get();

                            System.out.println(
                                    "In server" + new String(buffer.array()));

                            buffer.flip();
                            f = result.write(buffer);
                        }
                        catch (Exception e) {
                            // TODO: handle exception
                        }
                        finally {
                            server.accept(null, this);
                            try {
                                f.get();
                                result.close();
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("failed:" + exc);
                    }
                });
    }
}
