package PCD.ClientServer.EsRMI;

/**
 * Created by davide on 23/01/16.
 */
import java.net.*;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class SimpleServer{
    public static void main(String[] args) throws MalformedURLException, RemoteException, AlreadyBoundException {
        XMathImpl ref = new XMathImpl();
        Naming.bind("rmi://localhost/XMath",ref);
        System.out.println("Server pronto");
    }
}
