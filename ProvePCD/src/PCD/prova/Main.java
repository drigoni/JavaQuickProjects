package PCD.prova;

/**
 * Created by davide on 13/12/15.
 */
public class Main {
    public static void main(String[] args) {
        Number n = new Number();
        Screen s1 = new Screen(n,"a");
        Screen s2 = new Screen(n,"b");

        System.out.println("Inizio s1");
        s1.start();
        System.out.println("Inizio s2");
        s2.start();


        System.out.println("Fine MAIN");
    }
}
