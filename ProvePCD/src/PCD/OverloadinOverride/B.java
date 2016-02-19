package PCD.OverloadinOverride;

/**
 * Created by davide on 25/01/16.
 */
public class B extends A {
    public double m(double a){
        System.out.println("B.m()");
        return a;
    }
}
