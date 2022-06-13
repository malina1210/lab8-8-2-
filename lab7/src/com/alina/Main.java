package com.alina;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Player[] players = new Player[3];
        players[0] = new Player("Ivanov", LocalDate.of(2004,2,13),"Dnipro",Roles.CB,50,"Kyiv");
        players[1] = new Player("Petrov", LocalDate.of(2001,4,15),"Kharkiv",Roles.AM,41,"Kharkiv");
        players[2] = new Player("Doncov", LocalDate.of(2005,6,5),"Lviv",Roles.SS,60,"Lviv");

        for(int i = 0;i< players.length;i++){
            if(players[i].getBirth().isAfter(LocalDate.of(2001,12,30))&&players[i].getNumberOfGames()>40){
                System.out.println(players[i]);
            }
        }
    }
}
