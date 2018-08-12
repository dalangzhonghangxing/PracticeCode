package annotation;

import java.lang.annotation.Annotation;
import java.util.Date;

@Time(isPrintTime = true)
public class TestAnnotation {

    public void TimeRun(TestAnnotation target) {
        Class<?> clazz = target.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Time) {
                if (((Time) annotation).isPrintTime()) {
                    Date begin = new Date();
                    target.run();
                    Date end = new Date();
                    System.out.println(end.getTime() - begin.getTime());
                }
            }
        }
    }

    public static void main(String[] args) {
        TestAnnotation t = new TestAnnotation();
        t.TimeRun(t);
    }

    public static void run() {
        for (int i = 0; i < 100000; i++)
            System.out.println(i);
    }
}
