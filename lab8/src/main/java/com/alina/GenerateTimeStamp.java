package com.alina;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class GenerateTimeStamp {
    public static String generateWithJsonExt(){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        return time+".json";
    }
    public static String generateWithTxtExt(){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        return time+".txt";
    }
}
