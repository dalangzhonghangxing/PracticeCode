package sxjm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CalDistance {
    static double[][] edges;
    static int[] flag;
    static int MAXINT = 0x7fffffff;
    static double MAXDOUBLE = Double.MAX_VALUE;
    static int length;
    static boolean[] ischoosed;
    static List<Point> pointList = new ArrayList<>();
    static Map<String, Point> points;
    static double speed;
    static double ratio;

    public static void init(double ratio) {
        // TODO Auto-generated method stub
        HashMap<Integer, HashMap<Integer, Double>> stepLength = new HashMap<Integer, HashMap<Integer, Double>>();
        HashMap<Integer, Double> step1 = new HashMap<Integer, Double>();

        points = new HashMap<>();
        pointList = new ArrayList<>();

        File pointFile = new File(
                "C:\\Users\\guhang\\Desktop\\解\\相关的要素名称及位置坐标数据.csv");
        File relationFile = new File("C:\\Users\\guhang\\Desktop\\解\\连通图.csv");
        try {
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(pointFile));
            BufferedReader bufferedReader = new BufferedReader(read);
            String line = "";
            String values[];
            while ((line = bufferedReader.readLine()) != null) {
                Point p = new Point();
                values = line.split(",");
                p.index = Integer.valueOf(values[3]);
                p.x = Double.valueOf(values[1]);
                p.y = Double.valueOf(values[2]);
                p.name = values[0];
                points.put(values[0], p);
                pointList.add(p);
            }

            length = points.keySet().size() + 1;
            edges = new double[length][length];
            for (int i = 1; i < length; i++)
                for (int j = 1; j < length; j++)
                    edges[i][j] = MAXDOUBLE;
            flag = new int[length];
            for (int i = 1; i < length; i++)
                flag[i] = MAXINT;

            read = new InputStreamReader(new FileInputStream(relationFile));
            bufferedReader = new BufferedReader(read);

            while ((line = bufferedReader.readLine()) != null) {
                values = line.split(",");
                Point start = points.get(values[0]);
                Point end = points.get(values[1]);
                double dis;
                if (values.length == 2)
                    dis = distance(start, end, 1.0);
                else
                    dis = distance(start, end, ratio);
                edges[start.index][end.index] = dis;
                edges[end.index][start.index] = dis;
            }
            read.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static double distance(Point a, Point b, double radio) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2))
                * radio;
    }

    public static Map<String, Object> dijkstra(double[][] edges, int[] flag,
            int begin, int end) {
        flag[begin] = -1;// 起始点
        int[] outIndex = new int[length];
        ischoosed = new boolean[length];
        for (int i = 1; i < length; i++) {
            ischoosed[i] = false;
            outIndex[i] = begin;
        }
        ischoosed[begin] = true;
        int nextNode = getMinNode(begin);
        while (nextNode != end) {
            // System.out.println(pointList.get(nextNode - 1).name);
            update(edges, flag, outIndex, begin, nextNode);
            ischoosed[nextNode] = true;
            nextNode = getMinNode(begin);
        }
        update(edges, flag, outIndex, begin, nextNode);

        List<String> pathNodes = new ArrayList<>();
        pathNodes.add(pointList.get(end - 1).name);
        int a = end;
        double sum = 0;
        Stack<Double> stack = new Stack<>();
        while (flag[a] != -1) {
            pathNodes.add(pointList.get(flag[a] - 1).name);
            sum += edges[a][flag[a]];
            stack.push(edges[a][flag[a]]);
            a = flag[a];
        }
        String beginNodeName = pathNodes.get(pathNodes.size() - 1);
        String path = beginNodeName + "->";
        double stepTime = 0;
        for (int q = pathNodes.size() - 2; q >= 0; q--) {
            path += pathNodes.get(q) + "->";
            Point beginNode = points.get(beginNodeName);
            Point endNode = points.get(pathNodes.get(q));
            stepTime = stack.pop() / speed;
//            System.out.print(beginNodeName + ","
//                    + String.format("%.4f", stepTime * 60) + ",");
            beginNodeName = pathNodes.get(q).toString();
        }
        path = path.substring(0, path.length() - 2);
        // System.out.print(path);
        Double time = sum / speed;
//        System.out.print(String.format("%.4f", time) + " ");
        Map<String, Object> res = new HashMap<>();
        res.put("path", path);

        res.put("time", time);
        return res;
    }

    public static int getMinNode(int begin) {
        double min = MAXDOUBLE;
        int index = -1;
        for (int i = 1; i < length; i++)
            if (edges[begin][i] < min && !ischoosed[i]) {
                min = edges[begin][i];
                index = i;
            }
        return index;
    }

    public static void update(double[][] edges, int[] flag, int[] outIndex,
            int begin, int node) {
        flag[node] = outIndex[node];
        for (int i = 1; i < length; i++) {
            if (edges[node][i] != MAXDOUBLE && !ischoosed[i]
                    && edges[begin][i] > edges[node][i] + edges[begin][node]) {
                edges[begin][i] = edges[node][i] + edges[begin][node];
                outIndex[i] = node;
            }
            // System.out.print(edges[begin][i]+",");
        }
        // System.out.print("\n");

    }

    public static Map<String, Object> run(int i, int j, double rat, double sp) {
        speed = sp;
        ratio = rat;
        CalDistance.init(ratio);
        return dijkstra(edges, flag, i, j);
    }

    // 计算每个J的出度和入度和
    public static void calInAndOut() {
        CalDistance.init(1);
        for (int i = 1; i <= 62; i++) {
            int sum = 0;
            double sumDis = 0;
            for (int j = 1; j < length; j++) {
                if (edges[i + 68][j] < MAXDOUBLE) {
                    sum++;
                    sumDis += edges[i + 68][j];
                }
            }
            // System.out.println("J" + i + ":" + sum);
            System.out.println("J" + i + ":" + sumDis / sum);
        }
    }
}
