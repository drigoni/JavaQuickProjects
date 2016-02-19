package PCD.ClientServer.Es913;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

/**
 * Created by davide on 23/01/16.
 */
public class SimpleClient extends Thread {
    String name;
    int port;
    Socket s;

    public SimpleClient(String _n,int _p){
        super(_n);
        port = _p;
        name=_n;
    }

    public void connect() throws IOException{
        s = new Socket(InetAddress.getByName("127.0.0.1"),port);

        Scanner in = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream());

        System.out.println("Invio Thread:" + name );
        out.println("Invio Thread:" + name );

        System.out.println("Risposta Thread:" + name );
        System.out.println(in.nextLine());
    }

    @Override
    public void run() {
        try {
            this.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
