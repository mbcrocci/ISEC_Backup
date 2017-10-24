import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable {
    private int port;

    public TCPServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket socket = new ServerSocket(this.port);

            for (;;) {
                Socket newClient = socket.accept();
                System.out.println("[SERVER]: Got a new connection from [" + newClient.getInetAddress() + "]");

                PrintStream out = new PrintStream(
                        newClient.getOutputStream(),
                        true
                );
                out.println(new java.util.Date());

                newClient.close();
            }
        } catch (Exception e) {
            System.out.println("ERRO");
        }


    }
}
