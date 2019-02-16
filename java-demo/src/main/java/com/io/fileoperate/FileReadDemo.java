package com.io.fileoperate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by lenovo on 2017/12/7.
 */
public class FileReadDemo {
    private Logger logger = LoggerFactory.getLogger(FileReadDemo.class);

    /**
     *
     * @param filePath
     *
     * <p>
     *     按字节流单个字符读取文件，
     * </p>
     */
    public void readFileByBytesStream(String filePath) {
        FileInputStream fileInputStream = null;
        File readFile = new File(filePath);
        if (!readFile.exists()) {
            logger.error("readFile, file path is not exists!" + filePath);
            return;
        }
        try {
            fileInputStream = new FileInputStream(readFile);
            int value = 0;
            byte[] bytes = new byte[(int) readFile.length()];
            while ((value = fileInputStream.read()) != -1) {
                System.out.print((char) value);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    logger.error("readFile, fileInputStream.close() is error! IOException:", e);
                }
            }

        }
    }

    /**
     *
     * @param fileName
     * <p>
     *     按字符流单个字符读取文件
     * </p>
     */
    public void readFileByCharacterStream(String fileName) {
        FileReader fileReader = null;
        if (fileName == null) {
            logger.error("readFileByCharacterStream, fileName is null!");
            return;
        }
        File fileRead = new File(fileName);
        if (!fileRead.exists()) {
            try {
                fileRead.createNewFile();
            } catch (IOException e) {
                logger.error("readFileByCharacterStream, fileName is null!");
                return;
            }
        }
        try {
            fileReader = new FileReader(fileRead);
            int value = 0;
            while ((value = fileReader.read()) != -1) {
                System.out.print((char) value);
            }
        } catch (FileNotFoundException e) {
            logger.error("readFileByCharacterStream,  is error! FileNotFoundException:", e);
        } catch (IOException e) {
            logger.error("readFileByCharacterStream,  is error! FileNotFoundException:", e);
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    logger.error("readFileByCharacterStream,  is error! fileReader.close():", e);
                }
            }
        }
    }

    /**
     *
     * @param fileName
     * <p>
     *     按字符流行读取文件
     * </p>
     */
    public  void readFileByBufferedReader(String fileName) {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        if (fileName == null) {
            logger.error("readFileByCharacterStream, fileName is null!");
            return;
        }
        File fileRead = new File(fileName);
        if (!fileRead.exists()) {
            try {
                fileRead.createNewFile();
            } catch (IOException e) {
                logger.error("readFileByCharacterStream, fileName is null!");
                return;
            }
        }
        try {

            fileReader = new FileReader(fileRead);
            bufferedReader = new BufferedReader(fileReader);
            String  value= "";
            while ((value = bufferedReader.readLine()) != null) {
                System.out.print(value);
            }
        } catch (FileNotFoundException e) {
            logger.error("readFileByCharacterStream,  is error! FileNotFoundException:", e);
        } catch (IOException e) {
            logger.error("readFileByCharacterStream,  is error! FileNotFoundException:", e);

        }finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFileByBufferedInputStream(String filePath) {
        BufferedInputStream bufferedInputStream = null;
        FileInputStream fileInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        File readFile = new File(filePath);
        if (!readFile.exists()) {
            logger.error("readFile, file path is not exists!" + filePath);
            return;
        }
        try {
            fileInputStream = new FileInputStream(readFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int value = 0;

            while ((value = bufferedInputStream.read()) != -1) {
                System.out.print((char) value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedInputStream!=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    logger.error("readFile, bufferedInputStream.close() is error! IOException:", e);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    logger.error("readFile, fileInputStream.close() is error! IOException:", e);
                }
            }

        }
    }

    public static void main(String[] args) {
        FileReadDemo fileReadDemo = new FileReadDemo();
        String fileName = "fileWriteTest.txt";
        fileReadDemo.readFileByBytesStream(fileName);
        fileReadDemo.readFileByCharacterStream(fileName);
    }
}
