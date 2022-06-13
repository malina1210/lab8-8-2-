package com.alina;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person[] persons = new Person[3];
        for(int i = 0;i<persons.length;i++){
            persons[i] = new Person();
        }
        persons[0].setSecondName("Ivanov");
        persons[0].setBirth(LocalDate.of(2000, 4, 13));
        persons[0].setDegree("Bachelor");
        persons[0].setJob("Cassir");
        persons[0].setSalary(10000);

        persons[1].setSecondName("Tarasov");
        persons[1].setBirth(LocalDate.of(1999, 3, 24));
        persons[1].setDegree("Middle");
        persons[1].setJob("Dvornik");
        persons[1].setSalary(8000);

        persons[2].setSecondName("Nikitin");
        persons[2].setBirth(LocalDate.of(2002, 6, 8));
        persons[2].setDegree("Middle");
        persons[2].setJob("Dvornik");
        persons[2].setSalary(8000);

        int pos = 0;
        for (int i = 1; i < persons.length; i++) {
            if (persons[i].getBirth().isAfter(persons[pos].getBirth())) {
                pos=i;
            }
        }
        persons[pos].showInfo();
    }
}
