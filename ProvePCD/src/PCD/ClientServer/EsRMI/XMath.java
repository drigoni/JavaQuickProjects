package PCD.ClientServer.EsRMI;

import java.rmi.Remote;
import java.rmi.*;

/**
 * Created by davide on 24/01/16.
 */

public interface XMath extends Remote{
    public int XCalculation() throws RemoteException;
}

