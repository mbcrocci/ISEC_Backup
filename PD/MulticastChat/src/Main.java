import javax.xml.crypto.Data;
import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String []args) {
        try {
            // Criar socket multicast associado ao grupo "224.1.1.1" e porto 6001
            InetAddress group = InetAddress.getByName("224.1.1.1");

            MulticastSocket socket = new MulticastSocket(6001);
            socket.joinGroup(group);

            // Lancar thread dedicada a receber datagrams na socket multicast e mostrar conteudo
            Server server = new Server(socket);
            new Thread(server).start();

            // Aguardar por mensagens no System.in e envia para o ... para o porto 6001

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            ByteArrayOutputStream buff = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buff);

            while (true) {
                System.out.print(">>> ");
                String msg = in.readLine();

                out.writeObject(new Msg("monk", msg));

                out.flush(); out.close();

                DatagramPacket packet = new DatagramPacket(
                        buff.toByteArray(), buff.size(), group, 6001
                );

                socket.send(packet);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
