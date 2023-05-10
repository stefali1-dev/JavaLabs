import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {

    String serverAddress;
    int PORT;

    public GameClient(String serverAddress, int PORT){
        this.serverAddress = serverAddress;
        this.PORT = PORT;
    }

    public void runClient() throws IOException {
        Socket socket = new Socket(serverAddress, PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        String request = "World";
        out.println(request);
        String response = in.readLine ();
        System.out.println(response);
    }

}
