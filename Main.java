import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {

        GameClient gameClient = new GameClient("127.0.0.1", 8100);
        try{
            gameClient.runClient();
        } catch(UnknownHostException e) {
            System.err.println("No server listening..." + e);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
