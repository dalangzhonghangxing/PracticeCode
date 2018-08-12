package 笔试;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 华为2 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String in = sc.nextLine();
        // String query = sc.nextLine();
        String in = "typedef long LONG; typedef int INTP; typedef INTP A;";
        String query = "A";

        if (in == null || in.length() == 0) {
            System.out.println("none");
            return;
        }

        StringBuffer stars = new StringBuffer();

        // 处理query中的*
        int qstarPos = query.indexOf("*");
        if (qstarPos != -1) {
            stars.append(query.substring(qstarPos));
            query = query.substring(0, qstarPos);
        }
        Map<String, String> typemap = new HashMap<>();
        Map<String, String> starmap = new HashMap<>();
        Set<String> basic = new HashSet<>();
        basic.add("int");
        basic.add("void");
        basic.add("bool");
        basic.add("short");
        basic.add("long");
        basic.add("float");
        basic.add("double");
        basic.add("char");

        String segments[] = in.split(";");

        // check
        for (String segment : segments) {
            String[] values = segment.trim().split("\\s+");
            if (values.length != 3 || !values[0].equals("typedef")
                    || basic.contains(values[2])) {
                System.out.println("none");
                return;
            }
        }

        for (String segment : segments) {
            String[] values = segment.trim().split("\\s+");
            int starPos = values[1].indexOf("*");
            if (starPos == -1) starPos = values[1].length();
            String type = values[1].substring(0, starPos);
            String cstar = values[1].substring(starPos, values[1].length());
            if (basic.contains(type)) {// 基本类型不再二次查找
                typemap.put(values[2], type);
                starmap.put(values[2], cstar);
            } else {
                if (typemap.get(type) == null) { // 非基本类型不存在
                    System.out.println("none");
                    return;
                }
                typemap.put(values[2], type);
                starmap.put(values[2], cstar);
            }

        }

        if (typemap.get(query) == null) {
            System.out.println("none");
            return;
        }

        while (typemap.get(query) != null) {
            stars.append(starmap.get(query));
            query = typemap.get(query);
        }
        if (!basic.contains(query)) {
            System.out.println("none");
            return;
        }
        String s = "";
        for (int i = 0; i < stars.length(); i++) {
            s += " *";
        }
        System.out.println(query + s);
    }
}
