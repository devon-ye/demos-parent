package org.devon.io.fileoperate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by lenovo on 2017/12/7.
 */
public class FileWriteDemo {
    private static Logger log = LoggerFactory.getLogger(FileWriteDemo.class);

    public void writeFileByBytesStream(String fileName, byte[] content) {
        if(fileName==null) {
            log.error("writeFileByBytesStream, fileName is null!");
            return;
        }
        FileOutputStream fileOutputStream = null;
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                log.error("writeFile, file.createNewFile() is error! IOException:",e);
            }
        }
        try {
            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(content);

        } catch (IOException e) {
            log.error("writeFile, fileOutputStream is error! IOException:",e);
        }finally {
            if(fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    log.error("writeFile, fileOutputStream.close() is error! IOException:",e);
                }
            }

        }


    }

    public void writeFileByCharacterStream(String fileName,String fileContent) {
        FileWriter fileWriter = null;
        if(fileName == null) {
            log.error("writeFileByCharacterStream, fileName is null!");
            return;
        }
        File writeFile = new File(fileName);
        if(!writeFile.exists()) {
            try {
                writeFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(writeFile,true);

            fileWriter.write(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter!= null){
                try {
                    fileWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        FileWriteDemo fileWriterDemo = new FileWriteDemo();
        String fileName = "fileWriteTest.txt";
        String content = "this content will writing file";
        String writeByCharacterContent = "this word is by character stream";
        fileWriterDemo.writeFileByBytesStream(fileName, content.getBytes());
        fileWriterDemo.writeFileByCharacterStream(fileName,writeByCharacterContent);
    }


}
