/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPointsonaLine_149 {
    public int maxPoints(Point[] points) {
        if(points.length == 0) return 0;
        if(points.length == 1) return 1;
        Set<Point> pSet = new HashSet<>();
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            if (pSet.contains(points[i])) continue;
            pSet.add(points[i]);
            int duplicates = 1;
            Map<String, Integer> map = new HashMap();
            for (int j = i + 1; j < points.length; j++) {
                if (isSame(points[i], points[j])) {
                    duplicates++;
                    continue;
                }
                // 计算(p1.x-p2.x)/(p1.y-p2.y)约分后的分子分母，将其作为HashMap的key
                int dx = points[i].x - points[j].x, dy = points[i].y - points[j].y;
                int gcd = gcd(dx, dy);
                String key = "" + dx / gcd + "#" + dy / gcd;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (int value : map.values()) {
                max = Math.max(max, value + duplicates);
            }

            //可能都是重复的点
            max = Math.max(max, duplicates);
        }
        return max;
    }

    public boolean isSame(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }

    public int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }

    public static void main(String[] avgs){

    }
}
