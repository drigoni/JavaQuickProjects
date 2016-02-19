package PCD.Es365;

/**
 * Created by davide on 21/01/16.
 */
public class B extends A {
    private int y = m();
    B(){
        System.out.print("B()");
    }

    public int m(){
        System.out.println("B.m()");
        return 2;
    }

    public static void main(String[] args) {
        B b= new B();
    }
}
