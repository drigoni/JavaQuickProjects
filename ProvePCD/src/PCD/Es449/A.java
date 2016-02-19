package PCD.Es449;

/**
 * Created by davide on 22/01/16.
 */
public abstract class A extends B implements X  {
    public void f() {
        System.out.println("A.f()");
    }
    public void g(){
        System.out.println("A.g()");
    }

    public abstract B f(B ref);
}
