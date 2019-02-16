package com.io.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by lenovo on 2017/12/2.
 */
public class FileLockDemo {

    public void lockDemo() {
        File file = new File("." + File.separator + "README.md");
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileChannel = fileInputStream.getChannel();

            FileLock fileLock = fileChannel.lock();
            //  FileLock fileLock =fileChannel.tryLock();
            //  fileLock =fileChannel.tryLock(0,0,true);
            if (fileLock != null) {
                Thread.sleep(300);
                fileLock.release();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
