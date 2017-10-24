import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TCPClient implements Runnable {
    private String name;
    private String hostname;
    private int port;
    private Socket socket;

    public TCPClient(String name, String hostname, int port) {
        this.name = "[" + name + "] ";
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            InetAddress addr = InetAddress.getByName(this.hostname);
            socket = new Socket(addr, this.port);
            System.out.println(this.name + "Connection established");

            PrintStream out = new PrintStream(this.socket.getOutputStream(), true);
            out.print("TIME\r\n");

            socket.setSoTimeout(2000);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            System.out.println(this.name + "Results: " + reader.readLine());

            socket.close();

        } catch (Exception e) {
            System.out.println(this.name + "NAO LEU");
        }
    }
}
