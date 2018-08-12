package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 7000;

        ServerSocket serverSocket = new ServerSocket(port);

        ExecutorService es = Executors.newCachedThreadPool();

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                es.execute(new ServerSocketProcessor(socket));
            }
        }
        finally {
            serverSocket.close();
        }

    }
}
