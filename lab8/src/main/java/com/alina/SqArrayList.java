package com.alina;

import java.util.ArrayList;
import java.util.LinkedList;

public class SqArrayList {
    public ArrayList<Squarelateral> list;

    public SqArrayList(){
        this.list = new ArrayList<>();
    }
    public void showAll(){
        for (var t:list){
            System.out.println(t.toString());
        }
    }

}
