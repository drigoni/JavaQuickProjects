package PCD.Es3111;

/**
 * Created by davide on 21/01/16.
 */
public class A {
    private float a = m(1234);
    float m(float x) {
        System.out.println("Afloat");
        return x;
    }

    float m(int x) {
        System.out.println("Aint");
        return x;
    }
}
