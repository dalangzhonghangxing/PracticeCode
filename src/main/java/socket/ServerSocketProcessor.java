package socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerSocketProcessor implements Runnable {
    private Socket socket;

    public ServerSocketProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));

            do {
                String requestStr = dis.readUTF();
                System.out.println(requestStr);
                dos.writeUTF("收到客户端数据啦");
                dos.flush();
            }
            while (dis.readInt() != 0);
        }
        catch (Exception e) {
//            e.printStackTrace();
        } finally {
            System.out.println("与客户端通信结束");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
