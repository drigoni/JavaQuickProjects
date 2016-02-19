package PCD.ClientServer.Es913;

/**
 * Created by davide on 23/01/16.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class SimpleServer extends Thread{
    int port;
    ServerSocket ss;

    public SimpleServer(int _p){
        port = _p;
    }

    public void activate(){
        try {
            ss = new ServerSocket(port);

            while(true) {
                Socket sc = ss.accept();
                new ClientManager(sc).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientManager extends Thread{
        Socket sc;
        public ClientManager(Socket _sc){
            sc = _sc;
        }

        public void manage() throws IOException {
            Scanner in = new Scanner(sc.getInputStream());
            PrintWriter out = new PrintWriter(sc.getOutputStream());

            String msg = in.nextLine();
            out.println("Ricevuto: " + msg);
        }

        @Override
        public void run() {
            super.run();
            try {
                manage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        activate();
    }
}
