package com.io.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by lenovo on 2017/12/2.
 */
public class FileLockDemo {

    public void lockDemo() {
        File file = new File( "."+File.separator+"README.md");
        try {
            FileInputStream fileInputStream =new FileInputStream(file);
            FileChannel fileChannel = fileInputStream.getChannel();

            FileLock fileLock =fileChannel.lock();
          //  FileLock fileLock =fileChannel.tryLock();
           // FileLock fileLock =fileChannel.tryLock(0,0,true);
            if(fileLock!= null) {
                Thread.sleep(300);
                fileLock.release();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
