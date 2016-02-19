package PCD.aereo;

import java.util.Random;
import java.util.Vector;

/**
 * Created by davide on 16/12/15.
 */
public class Aereo {
    private static int n = 0;
    private int num;
    private String direzione;

    public Aereo(String d){
        num=n++;
        direzione=d;
    }

    public void stampa()
    {
        System.out.println("aereo num: "+num+" "+ direzione);
    }

}


class GeneraArrivi extends Thread{
    private Controllore contr;
    GeneraArrivi(Controllore c){contr=c;}

    public Controllore getContr() {
        return contr;
    }

    @Override
    public void run(){
        int i = 0;
        while(i<10)
        {
            contr.add_arrivi(new Aereo("in arrivo"));
            i=i+1;
        }
    }
}
class GeneraPartenze extends Thread{
    private Controllore contr;
    GeneraPartenze(Controllore c){contr=c;}

    public Controllore getContr() {
        return contr;
    }

    @Override
    public void run(){
        int i = 0;
        while(i<15)
        {
            contr.add_partenze(new Aereo("in partenza"));
            i=i+1;
        }
    }
}

class Controllore extends Thread{
    private Vector<Aereo> coda_arrivi=new Vector<Aereo>();
    private Vector<Aereo> coda_partenze=new Vector<Aereo>();
    Object pista = new Object();

    public void add_arrivi(Aereo a){
        synchronized (coda_arrivi) {
            coda_arrivi.add(a);
            coda_arrivi.notify();
        }
    }

    public void add_partenze(Aereo a){
        synchronized (coda_partenze) {
            coda_partenze.add(a);
            coda_partenze.notify();
        }
    }



    private char prox_transito(){
        Random a = new Random();
        if(a.nextBoolean())
            return 'A';
        else
            return 'P';
    }


    @Override
    public void run(){
        int i = 0;
        while(i<25){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            char c = prox_transito();
            if(c == 'A' && coda_arrivi.size()!= 0)
                gestisci_arrivo();
            else
                gestisci_partenza();
            i++;
        }
    }

    public void gestisci_arrivo(){
        Aereo a = null;
        synchronized (coda_arrivi){
            if(coda_arrivi.size()==0)
            {
                new TS(coda_arrivi).start();
                return;
            }
            else
                a = coda_arrivi.remove(0);
        }

        synchronized (pista){
            a.stampa();
        }
    }

    public void gestisci_partenza(){
            Aereo a = null;
            synchronized (coda_partenze){
                if(coda_partenze.size()==0)
                {
                    new TS(coda_partenze).start();
                    return;
                }
                else
                    a = coda_partenze.remove(0);
            }

            synchronized (pista){
                a.stampa();
            }
    }


    private class TS extends Thread{
        Vector<Aereo> coda;
        TS(Vector<Aereo> s){coda=s;}

        @Override
        public void run() {
            Aereo a = null;
            synchronized (coda)
            {
                while(coda.size()==0) {
                    try {
                        coda.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                a = coda.remove(0);
            }

            synchronized (pista){
                System.out.print("Ritardo -> ");
                a.stampa();
            }
        }
    }



    public static void main(String[] args){
        Controllore contr=new Controllore();
        GeneraArrivi gA= new GeneraArrivi(contr);
        GeneraPartenze gP = new GeneraPartenze(contr);
        contr.start();
        gA.start();
        gP.start();

    }
}

