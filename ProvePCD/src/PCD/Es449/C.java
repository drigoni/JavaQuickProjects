package PCD.Es449;

import java.util.Objects;

/**
 * Created by davide on 22/01/16.
 */
public class C extends B implements X {
    public void f(){
        System.out.println("C.f()");
    }
    public void f(Object ref){
        System.out.println("C.f(Object)");
    }
}
