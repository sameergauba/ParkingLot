package com.gojeck.parkinglot.utils;

import java.util.List;

public class PrintUtil {
    public static void printStringList(List<String> list) {
        int i = 0;
        for (i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(list.get(i));
    }

    public static void printIntegerList(List<Integer> list) {
        int i = 0;
        for (i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(list.get(i));
    }
}
