package com.alina;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Squarelateral implements Serializable {
    private double[] a = new double[2];
    private double[] b = new double[2];
    private double[] c = new double[2];
    private double[] d = new double[2];

    public Squarelateral() {
    }

    public Squarelateral(double[] a, double[] b, double[] c, double[] d) {
        this.a = Objects.requireNonNull(a.clone(),"Param --a-- must not be NULL");
        this.b = Objects.requireNonNull(b.clone(),"Param --b-- must not be NULL");
        this.c = Objects.requireNonNull(c.clone(),"Param --c-- must not be NULL");
        this.d = Objects.requireNonNull(d.clone(),"Param --d-- must not be NULL");
    }

    public double findAB(){
        return Math.sqrt(Math.pow(b[0]-a[0],2)+Math.pow(b[1]-a[1],2));
    }

    public double findAD(){
        return Math.sqrt(Math.pow(d[0]-a[0],2)+Math.pow(d[1]-a[1],2));
    }

    public double findBC(){
        return Math.sqrt(Math.pow(c[0]-b[0],2)+Math.pow(c[1]-b[1],2));
    }

    public double findCD(){
        return Math.sqrt(Math.pow(d[0]-c[0],2)+Math.pow(d[1]-c[1],2));
    }

    public double findDiagonal(){
        return Math.sqrt(Math.pow(findAB(),2)+Math.pow(findBC(),2));
    }

    public static double findLineLength(double[] a, double[] b){
        return Math.sqrt(Math.pow(b[0]-a[0],2)+Math.pow(b[1]-a[1],2));
    }


    public boolean checkFigure(){
        double cosAB = findCos(a,b);
        if(cosAB== findCos(b,c)&&cosAB== findCos(c,d)&&cosAB== findCos(d,a)){
            return true;
        } else{
            return false;
        }
    }



    public static boolean checkFigureStatic(double[] a,double[] b,double[] c,double[] d){
        double cosAB = findCosStatic(a,b);
        if(cosAB== findCosStatic(b,c)&&cosAB== findCosStatic(c,d)&&cosAB== findCosStatic(d,a)){
            return true;
        } else{
            return false;
        }
    }

    public double findCos(double[] a, double[] b){
        Objects.requireNonNull(a, "GetCos param --a-- must be not NULL");
        Objects.requireNonNull(b, "GetCos param --b-- must be not NULL");
        return Math.floor(((a[0]*b[0]+a[1]*b[1])/(Math.sqrt(a[0]*a[0]+a[1]*a[1])*Math.sqrt(b[0]*b[0]+b[1]*b[1])))*100)/100;
    }

    public static double findCosStatic(double[] a, double[] b){
        Objects.requireNonNull(a, "GetCos param --a-- must be not NULL");
        Objects.requireNonNull(b, "GetCos param --b-- must be not NULL");
        return Math.floor(((a[0]*b[0]+a[1]*b[1])/(Math.sqrt(a[0]*a[0]+a[1]*a[1])*Math.sqrt(b[0]*b[0]+b[1]*b[1])))*100)/100;
    }

    public double findPerimeter(){
        return findCD()+ findAB()+ findAD()+ findBC();
    }

    public double findSquare(){
        return findAB()* findBC();
    }

    public Squarelateral generate(){
        Random random = new Random();
        int flag = 0;
        int t1=0,t2=0;
        while(flag!= 1){
            a[0] = random.nextInt(20)+1;
            a[1] = random.nextInt(20+1);
            t1 = random.nextInt(10)+1;
            t2 = random.nextInt(9)+1;
            b[0] = a[0];
            b[1] = a[1] + t2;
            c[0] = a[0] + t1;
            c[1] = a[1] + t2;
            d[0] = a[0] + t1;
            d[1] = a[1];
            if(Squarelateral.checkFigureStatic(a,b,c,d)){
                this.setA(a);
                this.setB(b);
                this.setC(c);
                this.setD(d);
                flag++;
            }
        }

        return this;
    }

    public double[] getA() {
        return a;
    }

    public void setA(double[] a) {
        this.a = Objects.requireNonNull(a.clone(),"Param --a-- must not be NULL");
    }

    public double[] getB() {
        return b;
    }

    public void setB(double[] b) {
        this.b = Objects.requireNonNull(b.clone(),"Param --b-- must not be NULL");
    }

    public double[] getC() {
        return c;
    }

    public void setC(double[] c) {
        this.c = Objects.requireNonNull(c.clone(),"Param --c-- must not be NULL");
    }

    public double[] getD() {
        return d;
    }

    public void setD(double[] d) {
        this.d = Objects.requireNonNull(d.clone(),"Param --d-- must not be NULL");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squarelateral that = (Squarelateral) o;
        return Arrays.equals(getA(), that.getA()) && Arrays.equals(getB(), that.getB()) && Arrays.equals(getC(), that.getC()) && Arrays.equals(getD(), that.getD());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getA());
        result = 31 * result + Arrays.hashCode(getB());
        result = 31 * result + Arrays.hashCode(getC());
        result = 31 * result + Arrays.hashCode(getD());
        return result;
    }

    @Override
    public String toString() {
        return  "a=" + Arrays.toString(a) +
                ", b=" + Arrays.toString(b) +
                ", c=" + Arrays.toString(c) +
                ", d=" + Arrays.toString(d);
    }
}
