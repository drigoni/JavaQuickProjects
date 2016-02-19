package PCD.prova;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by davide on 13/12/15.
 */
public class Number {
    private int n;

    public Number(){
        n=0;
    }

    public synchronized int getN(){
        return n;
    }

    public synchronized void add(int _n){
        n=_n;
    }

    public synchronized void sub(int _n){
        n=-_n;
    }
}
