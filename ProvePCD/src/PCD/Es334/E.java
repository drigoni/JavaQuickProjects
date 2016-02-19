package PCD.Es334;

/**
 * Created by davide on 21/01/16.
 */
public class E extends D{
    int k = D.print("Non static E.k");
    E(){
        D.print("K= "+k);
    }
    static int x2 = D.print("static E.x2");

    public static void main(String[] args){
        D.print("Invocazione di E()");
        E e = new E();
    }
}