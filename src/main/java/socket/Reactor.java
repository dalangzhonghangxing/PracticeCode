package socket;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {

    public int i = 1000;

    public int bufferSize = 2048;

    @Override
    public void run() {
        init();
    }

    public void init() {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            channel.bind(new InetSocketAddress("localhost", 7000));
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT).attach(i++);
            System.out.println("server start at port:7000");
            listener(selector);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void listener(Selector selector) {
        try {
            while (true) {
                Thread.sleep(1000);
                int readyChannels = selector.selectNow();
                if (readyChannels <= 0) continue;
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> keys = selector.selectedKeys()
                        .iterator();
                while (keys.hasNext()) {
                    SelectionKey sk = keys.next();
                    keys.remove();
                    if (sk.isValid()) {
                        if (sk.isAcceptable()) {
                            System.out.println(sk.attachment() + " - 接受请求");
                            ServerSocketChannel channel = (ServerSocketChannel) sk
                                    .channel();
                            channel.accept().configureBlocking(false)
                                    .register(selector,
                                            SelectionKey.OP_READ
                                                    | SelectionKey.OP_WRITE)
                                    .attach(i++);

                            System.out.println(sk.attachment() + " - 已连接");
                        }

                        if (sk.isReadable()) {
                            System.out.println(sk.attachment() + " - 读取");
                            SocketChannel sc = (SocketChannel) sk.channel();
                            ByteBuffer bb = ByteBuffer.allocate(2048);
                            StringBuilder sb = new StringBuilder();
                            while (sc.read(bb) > 0) {
                                DataInputStream bis = new DataInputStream(
                                        new BufferedInputStream(
                                                new ByteArrayInputStream(
                                                        bb.array())));
                                sb.append(bis.readUTF());
                                bb.clear();

                            }
                            System.out
                                    .println(sk.attachment() + " - 读取到：" + sb);
                        }
                        if (sk.isWritable()) {
                            System.out.println(sk.attachment() + " - 写入");
                            SocketChannel sc = (SocketChannel) sk.channel();
                            String response = "hello\n";
                            ByteBuffer bb = ByteBuffer
                                    .allocate(response.getBytes().length);
                            bb.put(response.getBytes());
                            bb.flip();
                            sc.write(bb);
                        }

                        if (sk.isConnectable()) {
                            System.out.println(sk.attachment() + " - 连接事件");
                        }
                    }
                }
            }
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Reactor()).start();;
    }

}
