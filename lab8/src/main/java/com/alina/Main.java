package com.alina;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final String standartPathFile = "c:/labOut/";
        final String standartFileName = "out.txt";
        final String jacksonFileName = "out.json";
        int N = 10,M = 5;
        boolean testRandom = true;
        SqArrayList listN = new SqArrayList();
        SqArrayList listM = new SqArrayList();


        if(!testRandom)
        {
            listN = new ReadOnOpen().Read(standartPathFile);
            listN.showAll();
        }
        else
        {
            int flag = 0;
            while(flag!= N){
                listN.list.add(new Squarelateral().generate());
                flag++;
            }
            flag = 0;
            while(flag!= M){
                listM.list.add(new Square().generate());
                flag++;
            }

            listN.showAll();
            listM.showAll();

            double[] squares = new double[listN.list.size()];
            for(int i = 0;i<squares.length;i++){
                squares[i] = listN.list.get(i).findSquare();
            }
            double min = Arrays.stream(squares).min().getAsDouble();
            double max = Arrays.stream(squares).max().getAsDouble();

            Integer posMin = null,posMax = null;
            for(int i = 0;i<squares.length;i++){
                if(squares[i] == min){
                    posMin = i;
                }
                if(squares[i] == max){
                    posMax = i;
                }
            }
            if(posMin!=null){
                System.out.println("Squarelateral with max square: ");
                System.out.println(listN.list.get(posMax).toString());
            }
            if(posMax!=null){
                System.out.println("Squarelateral with min square: ");
                System.out.println(listN.list.get(posMin).toString());
            }

            for(int i = 0; i<listM.list.size()-1;i++){
                if(listM.list.get(i).equals(listM.list.get(i+1))){
                    System.out.println("These Squares are equal: "+i+" "+i+1);
                    System.out.println(listM.list.get(i).toString());
                    System.out.println(listM.list.get(i+1).toString());
                }
            }
        }



        SaveWithJackson save = new SaveWithJackson(jacksonFileName,standartPathFile,listN);
        save.Save();

        var allList = new ArrayList<Squarelateral>();
        allList.addAll(listN.list);
        allList.addAll(listM.list);
        SqArrayList all = new SqArrayList();
        all.list.addAll(allList);
        new SaveOnQuit().Save(standartPathFile,all);


    }
}
