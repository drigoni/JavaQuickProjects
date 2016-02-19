package PCD.Es423;

/**
 * Created by davide on 22/01/16.
 */
public abstract class A {
    abstract void m();
    public A(){
        System.out.println("In A() prima di m()");
        m();
        System.out.println("In A() dopo di m()");
    }
}
