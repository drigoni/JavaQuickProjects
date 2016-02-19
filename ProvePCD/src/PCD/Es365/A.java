package PCD.Es365;

/**
 * Created by davide on 21/01/16.
 */
public class A {
    private int x =m();
    A(){
        System.out.println("A()");
    }

    public int m(){
        System.out.println("A.m()");
        return 1;
    }
}
