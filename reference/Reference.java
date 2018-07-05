/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package reference;

public class Reference {
    public static void main(String[] avgs) {
        int i = 0;
        String s = "s";


        System.out.println(i);
        System.out.println(s);

        changeInteger(i);
        changeString(s);

        System.out.println(i);
        System.out.println(s);

    }

    public static void changeInteger(int i) {
        i = 1;
    }

    public static void changeString(String s) {
        s = "b";
    }

}
