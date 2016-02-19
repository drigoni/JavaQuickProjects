package PCD.torre;

import java.security.Guard;

/**
 * Created by davide on 16/12/15.
 */
public class Torre {
    private int n_inEntrata;
    private int n_inAlto;
    private int n_inTransito;

    Object lock_persone = new Object();
    Object lock_entrata = new Object();
    Object lock_salita = new Object();


    public Torre(){
        n_inAlto = 0;
        n_inEntrata = 0;
        n_inTransito = 0;
    }

    private class GuardiaEntrata extends Thread {
        @Override
        public void run() {
            while(true) {
                synchronized (lock_entrata) {
                    while (n_inEntrata == 0) {
                        try {
                            lock_entrata.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (n_inEntrata >= 10) {
                        n_inEntrata = n_inEntrata - 10;
                        System.out.println("10 Persone sono entrate nella torre");
                    } else {
                        System.out.println(n_inEntrata + " Persone sono entrate nella torre");
                        n_inEntrata = 0;
                    }
                }

                synchronized (lock_persone) {
                    System.out.println("Tempo di scorrere");
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    lock_persone.notify();
                }
            }
        }
    }

    private class GuardiaCima extends Thread{
        @Override
        public void run() {
            while(true) {
                synchronized (lock_salita) {
                    while (n_inAlto == 0) {
                        try {
                            lock_salita.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (n_inAlto >= 10) {
                        n_inAlto = n_inAlto - 10;
                        System.out.println("10 Persone stanno scendendo dalla torre");
                    } else {
                        System.out.println(n_inAlto + " Persone stanno scendendo dalla torre");
                        n_inAlto = 0;
                    }
                }

                synchronized (lock_persone) {
                    System.out.println("Tempo di scorrere");
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    lock_persone.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Torre t = new Torre();
        Torre.GuardiaCima  gC = t.new GuardiaCima();
        Torre.GuardiaEntrata gE = t.new GuardiaEntrata();
        gC.start(); gE.start();

        int i=0;
        while(i<100)
        {
            synchronized (t.lock_salita) {
                if (t.n_inAlto == 0)
                    t.n_inAlto = 3;
                else
                    t.n_inAlto++;

                t.lock_salita.notify();
            }


            synchronized (t.lock_entrata) {
                if (t.n_inEntrata == 0)
                    t.n_inEntrata = 3;
                else
                    t.n_inEntrata++;

                t.lock_entrata.notify();
            }

            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
