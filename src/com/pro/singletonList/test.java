package com.pro.singletonList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String args[]) {
        // create an array of string objs
        String init[] = { "One", "Two", "Three", "One", "Two", "Three" };

        // create one list
        List list = new ArrayList(Arrays.asList(init));

        System.out.println("List value before: " + list);

        list.add(init);
        System.out.println("List value after: " + list);
        // create singleton list
        list = Collections.singletonList("TP");

        System.out.println("List value after: " + list);
        list.add(init);
        System.out.println("List value after: " + list);
    }
}
