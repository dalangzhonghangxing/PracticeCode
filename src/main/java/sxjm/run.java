package sxjm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class run {
    public static void main(String[] args) {
        // for (int i = 1; i <= 2; i++)
        // for (int j = 9; j <= 68; j++)
        // CalDistance.run(1,2,(double) 30/50,30);
        // Cluster();
        // calBackDis();
        // calSecond();
         printTime();
        // compare();
//         clearResult();
        // ClusterCandinate();
        // calReverse();
        // calLeftToCandinateJ();
        // calPassedTimes();
        // calDisToZ();
        // calInAndOut();
        // calDisToD();
    }

    public static void printTime() {
        int[] D = new int[24];
        int[] F1 = new int[24];
        int[] Z = new int[24];
        int[] F2 = new int[24];
        int[] types = new int[24];
        File file = new File("C:\\Users\\guhang\\Desktop\\解\\1\\路径.txt");
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String line = "";
            String values[];
            line = bufferedReader.readLine();
            values = line.split(",");
            for (int i = 0; i < 24; i++)
                D[i] = Integer.valueOf(values[i].trim());
            line = bufferedReader.readLine();
            values = line.split(",");
            for (int i = 0; i < 24; i++)
                F1[i] = Integer.valueOf(values[i].trim());
            line = bufferedReader.readLine();
            values = line.split(",");
            for (int i = 0; i < 24; i++)
                Z[i] = Integer.valueOf(values[i].trim());
            line = bufferedReader.readLine();
            values = line.split(",");
            for (int i = 0; i < 24; i++)
                F2[i] = Integer.valueOf(values[i].trim());
            line = bufferedReader.readLine();
            values = line.split(",");
            for (int i = 0; i < 24; i++)
                types[i] = Integer.valueOf(values[i].trim());
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                read.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        int type = 1;
        double radio = 0, speed = 0;
        double sum = 0;
        for (int i = 0; i < 24; i++) {
            double one = 0;
            type = types[i];
            if (type == 1) {
                radio = (double) 45 / 70;
                speed = 45;
            } else if (type == 2) {
                radio = (double) 35 / 60;
                speed = 35;
            } else if (type == 3) {
                radio = (double) 30 / 50;
                speed = 30;
            }
            Map res;
            res = CalDistance.run(D[i], 8 + F1[i], radio, speed);
            // System.out.println(Double.valueOf(res.get("time").toString()) *
            // 60);
            // System.out.println("\ttime:" + String.format("%.4f",
            // Double.valueOf(res.get("time").toString())));
            sum += Double.valueOf(res.get("time").toString());
            one += Double.valueOf(res.get("time").toString());
//             System.out.println(Double.valueOf(res.get("time").toString())*60);
            res = CalDistance.run(8 + F1[i], 2 + Z[i], radio, speed);
            one += Double.valueOf(res.get("time").toString());
//            sum += Double.valueOf(res.get("time").toString());
            // System.out.println(Double.valueOf(res.get("time").toString()) *
            // 60);
            res = CalDistance.run(2 + Z[i], 8 + F2[i], radio, speed);
            one += Double.valueOf(res.get("time").toString());
            // System.out.println(Double.valueOf(res.get("time").toString()) *
            // 60);
//            sum += Double.valueOf(res.get("time").toString());
//             System.out.print("F" + F2[i] + "\n");
            System.out.println(one*60);
        }
//        System.out.println(sum*60);
    }

    public static void calSecond() {
        int[] unusedFIndex = { 1, 2, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 27, 28, 30, 32, 33, 36, 40, 48, 50, 51,
                52, 53, 55, 56, 57, 59, 60 };
        int[] centers = { 6, 6, 2, 6, 6, 6, 2, 4, 6, 4, 34 + 66, 49 + 66, 4, 4,
                5, 5, 5, 3, 1, 34 + 66, 1, 1, 1, 1 };
        int[] types = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3 };
        List<Integer> unusedFI = new ArrayList<>();
        for (int item : unusedFIndex) {
            unusedFI.add(item);
        }
        List<Map> disAndPaths = new ArrayList<>();
        double sum = 0;
        for (int i = centers.length - 1; i >= 0; i--) {
            int center = centers[i] + 2;
            int type = types[i];
            String filename = "";
            if (type == 1)
                filename = "A" + center;
            else if (type == 2)
                filename = "B" + center;
            else
                filename = "C" + center;
            File file = new File("C:\\Users\\guhang\\Desktop\\解\\2\\J34 J49\\"
                    + filename + ".txt");
            InputStreamReader read = null;
            try {
                read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String line = "";
                String values[];
                while ((line = bufferedReader.readLine()) != null) {
                    values = line.split(",");
                    if (values.length == 2) {
                        Map disAndPath = new HashMap<>();
                        disAndPath.put("dis", values[0]);
                        disAndPath.put("path", values[1]);
                        disAndPaths.add(disAndPath);
                    }
                }
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally {
                try {
                    read.close();
                }
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            String path = "";
            int FIndex = -1;
            double min = Double.MAX_VALUE;
            int index = -1;
            for (Map disAndPath : disAndPaths) {
                path = disAndPath.get("path").toString();
                FIndex = Integer.valueOf(
                        path.substring(path.length() - 2, path.length()));
                if (unusedFI.contains(FIndex) && min > Double
                        .valueOf(disAndPath.get("dis").toString())) {
                    min = Double.valueOf(disAndPath.get("dis").toString());
                    index = FIndex;
                }
            }
            unusedFI.remove(unusedFI.indexOf(index));
            sum += min;
            // System.out.println(index);
            if (type == 3) System.out.println(min * 60);

        }
        System.out.println("以上是Z->F-----------------------------");
        System.out.println("Z->F总耗时:" + sum * 60);
    }

    public static void calBackDis() {
        int[] usedFIndex = { 37, 39, 54, 4, 5, 6, 29, 31, 38, 3, 26, 49, 34, 35,
                41, 42, 43, 58, 24, 25, 44, 45, 46, 47 };
        int[] centers = { 6, 6, 2, 6, 6, 6, 2, 4, 6, 4, 34 + 66, 49 + 66, 4, 4,
                5, 5, 5, 3, 1, 34 + 66, 1, 1, 1, 1 };
        int[] type = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3 };
        double sum = 0;
        for (int i = 0; i < usedFIndex.length; i++) {
            double radio = -1;
            double speed = -1;
            if (type[i] == 1) {
                radio = (double) 45 / 70;
                speed = 45;
            } else if (type[i] == 2) {
                radio = (double) 35 / 60;
                speed = 35;
            } else if (type[i] == 3) {
                radio = (double) 30 / 50;
                speed = 30;
            }
            Map res = CalDistance.run(2 + centers[i], 8 + usedFIndex[i], radio,
                    speed);
            double time = Double.valueOf(res.get("time").toString());
            sum += time;
            if (type[i] == 3) System.out.println(time * 60);
        }

        System.out.println("以上是F->Z耗时---------------------------");

        System.out.println("F->Z总耗时:" + sum * 60);
    }

    public static void Cluster() {
        String path = "C:\\Users\\guhang\\Desktop\\解\\2\\J34 J49";
        int[] usedFIndex = { 1, 2, 3, 24, 25, 26, 29, 30, 31, 32, 33, 34, 35,
                57, 58, 41, 42, 43, 44, 48, 49, 45, 46, 47 };
        int[] candinate = { 25, 34, 36, 42, 49 };
        // int[] candinate = { 34, 49 };
        Set<Integer> usedF = new HashSet<>();
        for (int index : usedFIndex)
            usedF.add(index);

        double min = Double.MAX_VALUE;
        String minPath;
        int minIndex = -1;
        Map minMap = null;
        Map<Integer, List> ans = new HashMap<>();
        for (int i = 1; i <= 60; i++) {
            // if (usedF.contains(i)) continue;
            min = Double.MAX_VALUE;
            for (int z = 1; z <= 6; z++) {
                Map res = CalDistance.run(z + 2, i + 8, (double) 45 / 70, 45.0);
                if (Double.valueOf(res.get("time").toString()) < min) {
                    min = Double.valueOf(res.get("time").toString());
                    minIndex = z + 2;
                    minMap = res;
                    minMap.put("Findex", i + 8);
                }
            }
            for (int j = 0; j < candinate.length; j++) {
                Map res = CalDistance.run(candinate[j] + 68, i + 8,
                        (double) 30 / 50, 30.0);
                if (Double.valueOf(res.get("time").toString()) < min) {
                    min = Double.valueOf(res.get("time").toString());
                    minIndex = candinate[j] + 68;
                    minMap = res;
                    minMap.put("Findex", i + 8);
                }
            }
            List list = ans.get(minIndex);
            if (list == null) list = new ArrayList<Map>();
            list.add(minMap);
            ans.put(minIndex, list);

        }

        for (Integer key : ans.keySet()) {
            File file = new File(path + "\\A" + key + ".txt");
            List<Map> list = ans.get(key);
            String content = "";
            for (Map l : list) {
                content += l.get("time").toString();
                content += "," + l.get("path").toString() + "\n";
            }
            writeFile(file, content);
        }
    }

    public static void writeFile(File file, String content) {
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            writer.write(content);
            writer.flush();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
                fw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void compare() {
        File ourfile = new File(
                "C:\\Users\\guhang\\Desktop\\解\\1\\D-F_Distance.txt");
        File theirfile = new File("C:\\Users\\guhang\\Desktop\\解\\1\\out.txt");

        String line;
        String[] values;
        InputStreamReader read = null;
        double ourData[] = new double[360];
        double theirData[] = new double[360];
        try {
            read = new InputStreamReader(new FileInputStream(ourfile));
            BufferedReader bufferedReader = new BufferedReader(read);

            line = bufferedReader.readLine();
            values = line.split(" ");
            for (int i = 0; i < 360; i++)
                ourData[i] = Double.valueOf(values[i]);

            read = new InputStreamReader(new FileInputStream(theirfile));
            bufferedReader = new BufferedReader(read);
            line = bufferedReader.readLine();
            values = line.split(" ");
            for (int i = 0; i < 360; i++)
                theirData[i] = Double.valueOf(values[i]);

            int sames = 0;
            for (int i = 0; i < 360; i++)
                if (ourData[i] - theirData[i] > 0.0001)
                    System.out.println(ourData[i] + "------" + theirData[i]);
                else {
                    sames++;
                }
            System.out.println(sames);

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                read.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void clearResult() {
        File file = new File("C:\\Users\\guhang\\Desktop\\解\\1\\位置时刻表.txt");

        String line;
        String[] values;
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String content = "";
            while ((line = bufferedReader.readLine()) != null) {
                values = line.split(",");
                content += values[0] + ",";
                double currentTime = 0;
                for (int i = 1; i < values.length; i += 2) {
                    currentTime += Double.valueOf(values[i]) * 60;
                    content += currentTime + "," + values[i + 1] + ",";
                }
                content += "\n";
            }
            System.out.println(content);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                read.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void ClusterCandinate() {
        String path = "C:\\Users\\guhang\\Desktop\\解\\2";
        int candinateIndex[] = { 25, 34, 36, 42, 49 };
        int Findex[] = { 25, 26, 27, 28, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,
                55, 56, 58, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 21, 22, 36, 37, 38, 39 };
        double min = Double.MAX_VALUE;
        String minPath;
        int minIndex = -1;
        Map minMap = null;
        Map<Integer, List> ans = new HashMap<>();
        for (int i = 0; i < Findex.length; i++) {
            min = Double.MAX_VALUE;
            for (int z = 0; z < candinateIndex.length; z++) {
                Map res = CalDistance.run(candinateIndex[z] + 68, Findex[i] + 8,
                        (double) 30 / 50, 30.0);
                if (Double.valueOf(res.get("time").toString()) < min) {
                    min = Double.valueOf(res.get("time").toString());
                    minIndex = candinateIndex[z] + 68;
                    minMap = res;
                    minMap.put("Findex", Findex[i] + 8);
                }
            }
            List list = ans.get(minIndex);
            if (list == null) list = new ArrayList<Map>();
            list.add(minMap);
            ans.put(minIndex, list);
        }

        for (Integer key : ans.keySet()) {
            File file = new File(path + "\\ClusterCandinate" + key + ".txt");
            List<Map> list = ans.get(key);
            String content = "";
            for (Map l : list) {
                content += l.get("time").toString();
                content += "," + l.get("path").toString() + "\n";
            }
            writeFile(file, content);
        }
    }

    public static void calReverse() {
        File file = new File("C:\\Users\\guhang\\Desktop\\解\\1\\最终路径.txt");

        InputStreamReader read = null;
        double ourData[] = new double[360];
        double theirData[] = new double[360];
        String line = "";
        String[][] values = new String[24][];
        int j = 0;
        try {
            read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);

            while ((line = bufferedReader.readLine()) != null) {
                values[j++] = line.split(",");
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                read.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        for (int i = 0; i < values.length; i++)
            for (j = 0; j < values.length && j != i; j++)
                getReverse(i, j, values[i], values[j]);
    }

    public static void getReverse(int s, int e, String[] a, String[] b) {
        int p, q;
        boolean flag;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = b.length - 1; j >= 0; j--) {
                if (a[i].equals(b[j])) {
                    q = j - 1;
                    p = i + 1;
                    flag = false;
                    while (p < a.length && q >= 0 && a[p++].equals(b[q--])) {
                        flag = true;
                    }
                    if (flag)
                        System.out.println(String.format("第%d条路与第%d条路冲突:从%s到%s",
                                s + 1, e + 1, a[i], a[p - 2]));
                }
            }
        }

    }

    public static void calFirst() {
        // int[] usedFIndex = { 37, 38, 39, 4, 5, 6, 29, 30, 31, 3, 26, 49, 34,
        // 35,
        // 41, 42, 43, 58, 24, 25, 44, 45, 46, 47 };
        // int[] type = { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3,
        // 3,
        // 3, 3, 3, 3, 3 };
        // double sum = 0;
        // for (int i = 0; i < usedFIndex.length; i++) {
        // double radio = -1;
        // double speed = -1;
        // if (type[i] == 1) {
        // radio = (double) 45 / 70;
        // speed = 45;
        // } else if (type[i] == 2) {
        // radio = (double) 35 / 60;
        // speed = 35;
        // } else if (type[i] == 3) {
        // radio = (double) 30 / 50;
        // speed = 30;
        // }
        // Map res = CalDistance.run(2 + centers[i], 8 + usedFIndex[i], radio,
        // speed);
        // double time = Double.valueOf(res.get("time").toString());
        // sum += time;
        // }
        //
        // System.out.println(sum);
    }

    public static void calLeftToCandinateJ() {
        int[] unusedFIndex = { 7, 8, 9, 14, 15, 16, 17, 21, 22, 36, 40, 48, 52,
                56, 59 };
        int[] Jindex = { 4, 6, 8, 13, 14, 15 };
        for (int F : unusedFIndex) {
            double min = Double.MAX_VALUE;
            int minJ = -1;
            Map res;
            for (int J : Jindex) {
                res = CalDistance.run(F + 8, J + 68, 30.0 / 50, 30.0);
                if (Double.valueOf(res.get("time").toString()) < min) {
                    min = Double.valueOf(res.get("time").toString());
                    minJ = J;
                }
            }
            System.out.println(String.format("F%d->J%d:%f", F, minJ, min));
        }
    }

    // 计算每个J的通过车次数
    public static void calPassedTimes() {
        File file = new File("C:\\Users\\guhang\\Desktop\\解\\4\\最终路径.txt");

        InputStreamReader reader;
        String line;
        String values[];
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);

            Map<String, Integer> JTimes = new HashMap<>();
            while ((line = br.readLine()) != null) {
                values = line.split(",");
                for (String value : values) {
                    if (value.contains("J")) {
                        Integer counts = JTimes.get(value);
                        if (counts == null) counts = 0;
                        counts++;
                        JTimes.put(value, counts);
                    }
                }
            }

            Object[] key_arr = JTimes.keySet().toArray();
            Arrays.sort(key_arr);
            for (Object key : key_arr)
                System.out.println(key + ":" + JTimes.get(key));
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 计算离每个Z的距离和
    public static void calDisToZ() {
        Map res;
        for (int i = 1; i <= 62; i++) {
            double dis = 0;
            for (int j = 1; j <= 6; j++) {
                res = CalDistance.run(i + 68, j + 2, 1, 1);
                dis += Double.valueOf(res.get("time").toString());
            }
            System.out.println("J" + i + ":" + dis);
        }
    }

    // 计算出度入度、与周边节点平均距离、直接相连的F的数量
    public static void calInAndOut() {
        CalDistance.calInAndOut();
    }

    public static void calDisToD() {
        Map res1, res2;
        double dis1, dis2;
        for (int i = 1; i <= 62; i++) {
            res1 = CalDistance.run(i + 62, 1, 1, 1);
            res2 = CalDistance.run(i + 62, 2, 1, 1);
            dis1 = Double.valueOf(res1.get("time").toString());
            dis2 = Double.valueOf(res2.get("time").toString());
            System.out.println("J" + i + ":" + (dis1 < dis2 ? dis1 : dis2));
        }
    }
}
