package com.io.fileoperate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by lenovo on 2017/12/7.
 */
public class FileReadDemo {
    private Logger logger = LoggerFactory.getLogger(FileReadDemo.class);

    public void readFile(String filePath) {
        FileInputStream fileInputStream = null;
        File readFile = new File(filePath);
        if(!readFile.exists()) {
            logger.error("readFile, file path is not exists!" + filePath);
            return;
        }
        try {
            fileInputStream = new FileInputStream(readFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!= null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    logger.error("readFile, fileInputStream.close() is error! IOException:" , e);
                }
            }

        }


    }
}
