package PCD;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by davide on 24/01/16.
 */
public class ProveVeloci {
        public static void main(String[] args) {
            OutputStream in = null;
            try {
                in = Files.newOutputStream(Paths.get("prova.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int byter = 21;
            try {
                in.write(byter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
