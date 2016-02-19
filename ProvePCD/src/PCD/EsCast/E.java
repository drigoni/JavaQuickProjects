package PCD.EsCast;

import java.util.Objects;

/**
 * Created by davide on 21/01/16.
 */
public class E {
        public static void main(String[] args) {
            A a = new A();
            B b = new B();
            C c = new C();
            D d = new D();
            A ab = new B();

            A aa = (A)ab;
            //d = (D)ab; -> ClassCastException
            if(aa instanceof D)
                System.out.print("True");
            else
                System.out.print("False");

        }
}
