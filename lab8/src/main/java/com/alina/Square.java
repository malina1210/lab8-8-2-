package com.alina;

import java.io.Serializable;
import java.util.Random;

public class Square extends Squarelateral implements Serializable {
    public Square() {
    }

    public Square(double[] a, double[] b, double[] c, double[] d) {
        super(a, b, c, d);
    }

    @Override
    public boolean checkFigure(){
        if(super.findAB() == super.findBC() && super.findAB() == super.findCD() && super.findAB() == super.findAD()){
            return true;
        } else{
            return false;
        }
    }

    public static boolean checkFigureStatic(double[] a,double[] b,double[] c,double[] d){
        double AB = findLineLength(a,b);
        if(AB == findLineLength(b,c) && AB == findLineLength(c,d) && AB == findLineLength(a,d)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Squarelateral generate(){
        Random random = new Random();
        int flag = 0;
        int t1 = 0;
        while(flag!= 1){
            double[] a = new double[]{random.nextInt(20)+1, random.nextInt(20)+1};
            t1 = random.nextInt(20)+1;
            double[] b = new double[]{a[0],a[1]+t1};
            double[] c = new double[]{a[0]+t1,a[1]+t1};
            double[] d = new double[]{a[0]+t1,a[1]};

            if(Square.checkFigureStatic(a,b,c,d)){
                super.setA(a);
                super.setB(b);
                super.setC(c);
                super.setD(d);
                flag++;
            }
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Square{} " + super.toString();
    }
}
