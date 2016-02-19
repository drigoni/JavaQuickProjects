package PCD.Esemp842;
import java.util.*;
import java.io.*;

/**
 * Created by davide on 23/01/16.
 */
public class A {
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile("prova.txt","rw");
        for (int i = 0;i<10;i++)
            rf.writeDouble(i*2.0);
        rf.close();


        rf = new RandomAccessFile("prova.txt","rw");
        rf.seek(5*8);
        rf.writeDouble(999.0001);
        rf.close();


        rf = new RandomAccessFile("prova.txt","r");
        for (int i = 0;i<10;i++)
            System.out.println("Valore " + i + " : " + rf.readDouble());
        rf.close();

    }

}
