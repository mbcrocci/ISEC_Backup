import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class Server implements Runnable {
    private MulticastSocket socket;

    public Server(MulticastSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            byte []buff = new byte[4000];

            DatagramPacket packet = new DatagramPacket(buff, buff.length);

            while (true) {
                this.socket.receive(packet);

                ObjectInputStream in = new ObjectInputStream(
                        new ByteArrayInputStream(packet.getData(), 0, packet.getLength())
                );

                Object obj = in.readObject();
                in.close();

                if (obj instanceof Msg) {
                    Msg msg = (Msg) obj;

                    // Comando List (nao esta feito)

                    System.out.println(msg.getNickname() + ": " + msg.getMsg());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
