package org.devon.io.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by lenovo on 2017/12/2.
 */
public class FileChannelDemo {


    public void memoryMaped() {
        File file = new File("." + File.separator + "README.md");
        //   FileInputStream fileInputStream = null;
        RandomAccessFile randomAccessFile = null;
        FileChannel fileChannel = null;
        try {
           /*   FileInputStream unsupported writable, only used readable
           fileInputStream =new FileInputStream(file);
             fileChannel = fileInputStream.getChannel();*/
            randomAccessFile = new RandomAccessFile(file, "rw");
            fileChannel = randomAccessFile.getChannel();
            FileLock fileLock = fileChannel.lock();
            fileLock = fileChannel.tryLock(0, 0, true);
            byte[] data = null;
            if (fileLock != null) {
                MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, file.length());
                 data = new byte[(int) file.length()];
                int foot = 0;
                while (mappedByteBuffer.hasRemaining()) {
                    data[foot++] = mappedByteBuffer.get();
                }
                fileLock.release();
            }
            System.out.println(new String(data));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
