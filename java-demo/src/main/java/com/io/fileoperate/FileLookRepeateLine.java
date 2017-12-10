package com.io.fileoperate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/12/8.
 */
public class FileLookRepeateLine {
    private static Logger logger = LoggerFactory.getLogger(FileLookRepeateLine.class);
    private Map <String, List <Integer>> repeateLineMap = new HashMap <>();

    public void readFileByBufferedReader(String fileName) {

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
            String value = "";
            int i = 1;
            while ((value = bufferedReader.readLine()) != null) {
                if (!repeateLineMap.containsKey(value)) {
                    List <Integer> lineList = new ArrayList <>();
                    lineList.add(i);
                    repeateLineMap.put(value, lineList);
                } else {
                    List <Integer> lineList = repeateLineMap.get(value);
                    lineList.add(i);
                    repeateLineMap.put(value, lineList);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            logger.error("readFileByCharacterStream,  is error! FileNotFoundException:", e);
        } catch (IOException e) {
            logger.error("readFileByCharacterStream,  is error! FileNotFoundException:", e);

        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void printRepeateLine() {
        for (Map.Entry entry : repeateLineMap.entrySet()) {
            List <Integer> lineList = (List <Integer>) entry.getValue();
            if (lineList.size() > 1) {
                if (entry.getKey() == null || entry.getKey().toString().trim().length() == 0) {
                    System.out.println("detail:" + entry.getKey() + ",blank lineList:" + entry.getValue());
                } else {
                    System.out.println("detail:" + entry.getKey() + ",lineList:" + entry.getValue());
                }
            }
        }
    }


    public static void main(String[] args) {
        FileLookRepeateLine fileLookRepeateLine = new FileLookRepeateLine();
        String fileName = "fileWriteTest.txt";
        fileLookRepeateLine.readFileByBufferedReader(fileName);
        fileLookRepeateLine.printRepeateLine();
    }
}
