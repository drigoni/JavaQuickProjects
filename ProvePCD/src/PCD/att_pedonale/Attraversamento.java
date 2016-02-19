package PCD.att_pedonale;


/**
 * Created by davide on 16/12/15.
 */

class Investito extends Exception{
    int chi;
    int cosa;
    Investito(int i,int j){
        chi=i;
        cosa=j;
    }
    void info(){
        System.out.println("INCIDENTE: "+chi +" ha investito: "+cosa);
    }
}

public class Attraversamento {
    private boolean[] occupato = new boolean[3];

    Attraversamento(){
        occupato[0] = false; occupato[1]=false;occupato[2]=false;
    }

    public synchronized void occupa(int chi) throws Investito{
        System.out.println(Thread.currentThread().getName() + " é su un incrocio");

        if(chi!=0)
        {
            while(occupato[0] == true)
                try{
                    wait();
                }
                catch (InterruptedException e){}
        }
        else
        {
            while(occupato[1] || occupato[2])
                    try{
                        wait();
                    }
                    catch (InterruptedException e){}
        }

        occupato[chi] = true;

        if(chi==0 && occupato[1]==true) throw new Investito(0,1);
        if(chi==0 && occupato[2]==true) throw new Investito(0,2);
        if(chi!=0 && occupato[0]==true) throw new Investito(chi,0);
    }

    public synchronized void libero(int chi){
        occupato[chi]=false;
        notify();
    }
}

class Auto extends Thread{
    Attraversamento a;
    int direzione;
    int distanza;

    Auto(Attraversamento att, int dir,int dist,String nome){
        super(nome);
        a=att;
        direzione=dir;
        distanza=dist;
    }

    @Override
    public void run(){
        try
        {
            for (int i=distanza;i>0;i--)
            {
                sleep((int)Math.random()*20);
            }


                a.occupa(direzione);
                sleep(1);
                a.libero(direzione);
                System.out.println(getName()+" é passato" );

        }
        catch (InterruptedException e){}
        catch (Investito e){e.info();}
    }
}


class Pedone extends Thread{
    Attraversamento a;
    int distanza;

    Pedone(Attraversamento att,int dist){
        a=att;
        distanza=dist;
    }

    @Override
    public void run() {
        try {
            for (int i=distanza;i>0;i--)
            {
                sleep((int)Math.random()*80);
            }



                a.occupa(0);
                sleep(5);
                a.libero(0);
                System.out.println(getName() + " é passato" );



        }
        catch (InterruptedException e){}
        catch (Investito e){e.info();}
    }
}

class IncrocioPulito{
    public static void main(String[] args) {
        Attraversamento a = new Attraversamento();

        Auto a1 = new Auto(a,1,10,"Auto da sinistra");
        Auto a2 = new Auto(a,2,5,"Auto da destra");
        Pedone p = new Pedone(a,8);

        a1.start();a2.start();p.start();
    }
}