import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Main {

    static class Student {
        String sno;
        String name;

        @Override
        public int hashCode() {
            return sno.hashCode();
        }
    }

    public static void main(String[] args) {
        try {
            new ObjectInputStream(new FileInputStream("sadf"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
