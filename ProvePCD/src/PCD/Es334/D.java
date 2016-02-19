package PCD.Es334;

import java.io.IOException;

/**
 * Created by davide on 21/01/16.
 */
public class D {
    int i = 4;
    int j;
    D(){
        print("i= " +i+", j= "+j);
        j=7;
    }
    static int x1 =print("static D.x1");
    static int print(String s) {
        System.out.print(s);
        return 9;
    }
}
