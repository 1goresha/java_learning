package com.company;

import java.io.File;
import java.io.FileNotFoundException;

public class FileProperties {
    public String getAbsolute(String fileName) throws FileNotFoundException{
//        try{
//            FileUtil fileUtil = new FileUtil();
//            File file = fileUtil.openFile(fileName);
//            return file.getAbsolutePath();
//        }catch(FileNotFoundException e){
//            throw new IllegalArgumentException(e);
//        }

            FileUtil fileUtil = new FileUtil();
            File file = fileUtil.openFile(fileName);
            return file.getAbsolutePath();
    }
}
