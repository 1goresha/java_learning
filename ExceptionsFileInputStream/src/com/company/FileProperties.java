package com.company;

import java.io.File;
import java.io.FileNotFoundException;

public class FileProperties {
    public String getAbsolute(String fileName) throws FileNotFoundException {
        FileUtil fileUtil = new FileUtil();
        File file = fileUtil.openFile(fileName);
        return file.getAbsolutePath();
    }
}
