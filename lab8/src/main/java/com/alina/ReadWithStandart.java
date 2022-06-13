package com.alina;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

public class ReadWithStandart implements ISQReader{
    private String fileName;
    private String pathToFile;
    private SqArrayList sqArrayList = new SqArrayList();

    public ReadWithStandart(String fileName, String pathToFile){
        this.setFileName(fileName);
        this.setPathToFile(pathToFile);
    }

    @Override
    public boolean Read() {
        try{
            FileInputStream fileInputStream = new FileInputStream(pathToFile+fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Squarelateral> deserialized = (ArrayList<Squarelateral>) objectInputStream.readObject();
            sqArrayList.list.addAll(deserialized);
            objectInputStream.close();
        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        Objects.requireNonNull(fileName, "FileName arg must be not NULL");
        if(fileName == ""){
            System.out.println("setFileName String arg must be not empty");
            return;
        }
        this.fileName = fileName;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        Objects.requireNonNull(pathToFile, "pathToFile arg must be not NULL");
        if(fileName == ""){
            System.out.println("pathToFile String arg must be not empty");
            return;
        }
        this.pathToFile = pathToFile;
    }

    public SqArrayList getSqArrayList() {
        return sqArrayList;
    }

    private void setSqArrayList(SqArrayList sqArrayList) {
        Objects.requireNonNull(sqArrayList,"sqArrayList arg must not be NULL");
        if(sqArrayList.list.size()<1){
            System.out.println("sqArrayList size must not be <1");
            return;
        }
        this.sqArrayList = sqArrayList;
    }
}
