package org.devonmusa.util.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneMillionsIntNumberUsing1MSort {
    private static Logger LOG = LoggerFactory.getLogger(OneMillionsIntNumberUsing1MSort.class);
    private static String fileName = "1MillionsIntNumber.txt";
    private static String sortedFileName = "sortedIntNumber.txt";
    private static Random random = new Random();

    private final int COUNT = 1000;
    private final int MAX = 9999;

    public static void main(String[] args) {
        OneMillionsIntNumberUsing1MSort using1mSort = new OneMillionsIntNumberUsing1MSort();
        String dir = System.getProperty("user.dir");
        Long startTime = System.currentTimeMillis();

        Byte[] bytes = using1mSort.OneMllionIntNumberUseLeastMemorySort(dir + File.separator + fileName);

        using1mSort.writeSortedNumberIntoFile(bytes, dir + File.separator + sortedFileName);
        Long endTime = System.currentTimeMillis();
        LOG.info("Used time:" + (endTime - startTime));
    }

    public Byte[] OneMllionIntNumberUseLeastMemorySort(String filename) {
        File file = new File(filename);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {

        }
        BufferedReader bufferedReader = null;
        String tempString = null;
        Byte[] bytes = new Byte[MAX];
        int tempInt = 0;
        try {
            if (fileReader != null) {
                bufferedReader = new BufferedReader(fileReader);
            }
            if (bufferedReader != null) {
                while ((tempString = bufferedReader.readLine()) != null) {
                    tempInt = Integer.valueOf(tempString);
                    bytes[tempInt] = 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return bytes;
    }

    public void writeSortedNumberIntoFile(Byte[] bytes, String sortedFileName) {
        File file = new File(sortedFileName);
        LOG.info("file path" + file);
        FileWriter fileWriter = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int len = 0;
        if (bytes != null) {
            len = bytes.length;
            LOG.info("data byteArray legth:" + len);
        }
        try {
            for (int i = 0; i < len; i++) {
                if (bytes[i] == null) {
                    continue;
                } else {
                    if(fileWriter!=null) {
                        fileWriter.write(i + "\n");
                    }
                    LOG.info("Sorted number write to file:" + i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printfSortedNumber(Byte[] bytes) {
        int len = 0;
        if (bytes != null) {
            len = bytes.length;
        }

        for (int i = 0; i < len; i++) {
            if (bytes[i] != null) {
                LOG.info("number:" + i + " flag:" + bytes[i]);
            }
        }
    }

    public void productIntNumberWriteFile(String fileName) {
        File file = new File(fileName);
        FileWriter fileWriter = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file, true);
            int tempNumber = 0;
            int i = 0;
            while (i < COUNT) {
                tempNumber = random.nextInt(MAX);
                if (tempNumber > COUNT && tempNumber < MAX) {
                    fileWriter.write(tempNumber + "\n");
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
