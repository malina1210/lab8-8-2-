package com.alina;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    final int N = 20;
        Integer[] arr = new Integer[N];
        Random rand = new Random();
        for(int i = 0; i<N;i++){
            arr[i] = rand.nextInt(20);
        }
        Arrays.sort(arr);
        for(int t:arr){
            System.out.println(t);
        }
        System.out.println("----------");

        Integer[] arr2 = new Integer[N+2];
        for(int i = 1,j=0;i<N+1;i++,j++){
            arr2[i] = arr[j];
        }
        arr2[0] = null;
        arr2[N+1] = null;
        Integer[][] arr3;
        int counter = 0;
        for(int i = 1;i<N+2;i++){
            if(arr2[i]!=arr2[i-1]){
                counter++;
            }
        }
        arr3 = new Integer[counter][2];
        for(int i = 0;i<counter;i++){
            arr3[i][0] = 0;
            arr3[i][1] = 0;
        }
        int pos = 0;
        for(int i = 1;i<N+2;i++){
            if(arr2[i]==arr2[i-1]){
                arr3[pos][0] = arr2[i];
                arr3[pos][1]++;
            } else{
                pos++;
            }
        }
        Arrays.sort(arr3, Comparator.comparingDouble(o -> o[1]));
        for(int i = arr3.length-1;i>1;i--){
            if(arr3[i][1]>arr3[i-1][1]){
                System.out.println("Наименьшее наиболее встречаемое число: "+arr3[i][0]);
                break;
            }
        }
    }

}
