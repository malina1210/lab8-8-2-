package com.alina;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SaveWithJackson implements ISQSaver{
    private String fileName;
    private String pathToFile;
    private SqArrayList sqArrayList;

    public SaveWithJackson(String fileName, String pathToFile, SqArrayList sqArrayList){
        this.setFileName(fileName);
        this.setPathToFile(pathToFile);
        this.setSqArrayList(sqArrayList);
    }

    @Override
    public boolean Save() {
        try{
            File file = new File(pathToFile+fileName);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file,this.sqArrayList.list);
            return true;
        } catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
