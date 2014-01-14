package com.insecure.practice;

/**
 * IntelliJ Idea 13 Community Edition
 * Created by karan.khosla on 1/13/14.
 */
public class BitTest1 {


    public static void main(String[] args) {

        int i = 430479;
        int q = 47;

        int r = i - (q * 100);

        System.out.println("Value of r: " + r);

        r = i - ((q << 6) + (q << 5) + (q << 2));

        System.out.println("Value of r: " + r);

        r = i-(q*10);

        System.out.println("Value of r: " + r);

        r = i - ((q << 3) + (q << 1));

        System.out.println("Value of r: " + r);


        System.out.println(reverse("abc"));
    }

    public static String reverse(String s) {
        int n = s.length() - 1;
        char[] value = s.toCharArray();
        for (int j = (s.length() - 1) >> 1; j >= 0; --j) {
            char temp = value[j];
            char temp2 = value[n - j];
            value[j] = temp2;
            value[n - j] = temp;
        }
        return String.valueOf(value);
    }

}
