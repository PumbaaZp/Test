package com.pro.list;

import java.util.ArrayList;
import java.util.List;

public class subList {
    public static void main(String args[]){
        List<String> list = new ArrayList<String>();
        for(int i=0;i<1000;i++){
            list.add(String.valueOf(i));
        }
        System.out.println(list);
        for(int i=0;i<2;i++){
            System.out.println(list.subList(0, 300));
            list.subList(0, 300).clear();
            System.out.println(list);
        }
    }
}
