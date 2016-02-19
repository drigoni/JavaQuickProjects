package PCD.Es449;

/**
 * Created by davide on 22/01/16.
 */
public class D extends A {
    public static B st = new B();
    public void f(){
        System.out.println("D.f()");
    }
    public B f(B ref){
        if (ref instanceof A)
            return (D)ref;
        else
            return st;
    }

    public static void main(String[] args) {
        A a=new D();
        B b= a;
        b.g();
        a.g();
        a.f(b);
    }
}
