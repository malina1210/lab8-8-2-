package com.alina;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class SaveWithStandart implements ISQSaver{
    private String fileName;
    private String pathToFile;
    private SqArrayList sqArrayList;

    public SaveWithStandart(String fileName, String pathToFile, SqArrayList sqArrayList){
        this.setFileName(fileName);
        this.setPathToFile(pathToFile);
        this.setSqArrayList(sqArrayList);
    }


    @Override
    public boolean Save() {
        try{
            FileOutputStream fOS = new FileOutputStream(pathToFile+fileName);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(sqArrayList.list);
            oOS.flush();
            oOS.close();
            return true;
        }catch (java.io.IOException e){
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

    public void setSqArrayList(SqArrayList sqArrayList) {
        Objects.requireNonNull(sqArrayList,"sqArrayList arg must not be NULL");
        if(sqArrayList.list.size()<1){
            System.out.println("sqArrayList size must not be <1");
            return;
        }
        this.sqArrayList = sqArrayList;
    }
}
