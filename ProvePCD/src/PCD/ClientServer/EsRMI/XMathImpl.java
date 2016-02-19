package PCD.ClientServer.EsRMI;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by davide on 24/01/16.
 */
    public class XMathImpl extends UnicastRemoteObject implements XMath{
    int a,b;
    public XMathImpl(int _a,int _b) throws RemoteException{
        a = _a;
        b=_b;
    }
    public XMathImpl() throws RemoteException{
        a = 10;
        b= 10;
    }

    @Override
    public int XCalculation() throws RemoteException{
        return  a*a + b*b -a+b;
    }
}