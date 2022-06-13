package com.alina;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    private String secondName;
    private LocalDate birth;
    private String job;
    private String degree;
    private int salary;


    public Person(){

    }


    public Person(String secondName, LocalDate birth, String job, String degree, int salary) {
        this.secondName = secondName;
        this.birth = birth;
        this.job = job;
        this.degree = degree;
        this.salary = salary;
    }


    public void showInfo(){
        StringBuilder str = new StringBuilder();
        str.append("Second name: ").append(this.secondName);
        str.append("\nBirth date: ").append(this.birth.toString());
        str.append("\nJob: ").append(this.job);
        str.append("\nDegree: ").append(this.degree);
        System.out.println(str);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        if(birth.getYear()>2004){
            System.out.println("Wrong date");
            return;
        }
        this.birth = birth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
