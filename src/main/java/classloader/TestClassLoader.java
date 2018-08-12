package classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class TestClassLoader {
    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, InstantiationException {
        String stringClass = "public class A {public void print() { System.out.println(\"类加载成功...\");}}";
        Class<?> cls = getClass(stringClass);
        Method method = cls.getDeclaredMethod("print", null);
        method.invoke(cls.newInstance(), null);
        stringClass = "public class A {public void print() { System.out.println(\"改变了一点点\\n类加载成功...\");}}";
        cls = getClass(stringClass);
        method = cls.getDeclaredMethod("print", null);
        method.invoke(cls.newInstance(), null);

        // System.out.println(Integer.toBinaryString(1024 >>> 3));
        // System.out.println(Integer.toBinaryString(1024));
        // System.out.println(Integer.toBinaryString(~1024));
    }

    private static Class<?> getClass(String code) {
        String stringClass = code;
        String className = stringClass.split(" ")[2];
        File folder = new File("./src/TheadAndRunnable");
        File sourceFile = new File(folder, className + ".java");
        try {
            Files.write(sourceFile.toPath(),
                    stringClass.getBytes(StandardCharsets.UTF_8));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        if (compiler == null) System.out.println("No compiler");

        int compilationResult = compiler.run(null, null, null,
                sourceFile.getPath());

        try {

            URLClassLoader classLoader = URLClassLoader
                    .newInstance(new URL[] { folder.toURI().toURL() });
            Class<?> cls = Class.forName(className, true, classLoader);
            Object instance = cls.newInstance();
            sourceFile.delete();
            return cls;
        }
        catch (Exception e) {
            e.printStackTrace();
            sourceFile.delete();
        }
        return null;
    }
}
