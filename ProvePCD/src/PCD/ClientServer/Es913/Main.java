package PCD.ClientServer.Es913;

/**
 * Created by davide on 23/01/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int port = 5555;
        System.out.println("Inizio Main");
        SimpleServer server = new SimpleServer(port);
        server.start();
        Thread.sleep(2000);
        for(int i = 0; i<22; i++)
        {
            new SimpleClient("N" + i,port).start();
        }
        System.out.println("Fine Main");
    }
}
