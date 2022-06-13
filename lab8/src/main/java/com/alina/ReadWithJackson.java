package com.alina;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadWithJackson implements ISQReader{
    private String fileName;
    private String pathToFile;
    private SqArrayList sqArrayList = new SqArrayList();

    public ReadWithJackson(String fileName, String pathToFile){
        this.setFileName(fileName);
        this.setPathToFile(pathToFile);
    }

    public boolean Read(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Squarelateral> sqArrayList = mapper.readValue(new File(pathToFile + fileName), new TypeReference<ArrayList<Squarelateral>>(){});
            this.sqArrayList.list.addAll(sqArrayList);
            return true;
        } catch (StreamReadException e) {
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
