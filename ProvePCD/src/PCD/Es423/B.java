package PCD.Es423;

/**
 * Created by davide on 22/01/16.
 */
public class B extends A{
    int k=1;
    public void m(){
        System.out.println("B.m(), k= "+k);
    }

    public B(int x){
        k=x;
        System.out.println("B.B(), k= "+k);
    }

    public static void main(String[] args) {
        new B(3);
    }
}
