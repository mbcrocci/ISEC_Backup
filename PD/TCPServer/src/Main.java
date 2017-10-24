import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TCPClient []clients = {
                //new TCPClient("10.65.132.252", 5001),
                new TCPClient("profWired","10.204.128.70", 5001),
                new TCPClient("monk", "127.0.0.1", 5001),
                new TCPClient("Igor","192.168.2.2", 5001),
                //new TCPClient("Protas","192.168.2.3", 5001)
        };

        for (TCPClient client : clients)
            new Thread(client).start();

        TCPServer server1 = new TCPServer(5001);
        new Thread(server1).start();
    }
}
