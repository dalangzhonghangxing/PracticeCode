package socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args)
            throws UnknownHostException, IOException {
        int port = 7000;

        String host = "localhost";

        Socket socket = new Socket(host, port);

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));

        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));

        dos.writeUTF("aaaasd");
        dos.flush();

        System.out.println(dis.readUTF());

        socket.close();

    }
}
