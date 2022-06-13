package com.alina;

import java.io.File;

public class SaveOnQuit{
    public boolean Save(String path,SqArrayList sqList){
        String fileName = GenerateTimeStamp.generateWithJsonExt();
        var writer = new SaveWithJackson(fileName,path,sqList);
        if(writer.Save()){
            return true;
        } else{
            return false;
        }
    }


}
