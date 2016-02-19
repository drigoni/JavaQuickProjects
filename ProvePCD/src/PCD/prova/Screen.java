package PCD.prova;

import java.lang.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by davide on 13/12/15.
 */
public class Screen extends Thread{
    private final Number cont;
    private String val;

    //constructor
    public Screen(Number _cont, String _val)
    {
        cont=_cont;
        val = _val;
    }

    @Override
    public void run(){
        while (cont.getN() <= 100) {
            synchronized (cont) {
                int a = cont.getN();
                System.out.println(val + " " + a);
                cont.add(a + 1);
                try {
                    cont.notify();
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
