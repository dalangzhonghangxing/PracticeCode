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
        Set<Student> s = new HashSet<>();
        Student student = new Student();
        student.sno = "1";
        student.name = "1";
        s.add(student);
        student.sno = "2";
        s.add(student);
        out.println(s.size());
    }

}
