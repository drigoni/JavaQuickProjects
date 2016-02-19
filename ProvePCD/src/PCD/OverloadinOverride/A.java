package PCD.OverloadinOverride;

import javax.net.ssl.SSLContext;

/**
 * Created by davide on 25/01/16.
 */
public class A {
    public long m(int a){
        System.out.println("A.m()");
        return a;
    }
}
