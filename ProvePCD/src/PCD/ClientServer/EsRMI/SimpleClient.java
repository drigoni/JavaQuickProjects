package PCD.ClientServer.EsRMI;

/**
 * Created by davide on 23/01/16.
 */
import java.net.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * Created by davide on 23/01/16.
 */
public class SimpleClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        XMath xm = (XMath) Naming.lookup("rmi://localhost/XMath");
        System.out.println("Risultato calcolo: "+ xm.XCalculation() );
    }
}
