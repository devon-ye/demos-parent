package com.io.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lenovo on 2017/11/8.
 */
public class GetChannel {
    private static final Logger LOG = LoggerFactory.getLogger(GetChannel.class);
    private static final int BATCH_SIZE = 1024;


    public void writeFileByFileOutputStream(String filePath, String context) {
        FileChannel fc = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            fc = fileOutputStream.getChannel();
            ByteBuffer bf = ByteBuffer.wrap(context.getBytes());
            fc.write(bf);

        } catch (Exception e) {
            LOG.error("writeFileByFileOutputStream,Exception:", e);
        } finally {

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writerFileByRandomAccessFile(String fileName, String context) {
        FileChannel fc = null;
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(fileName, "rw");
            fc = randomAccessFile.getChannel();
            fc.position();
            ByteBuffer bf = ByteBuffer.wrap(context.getBytes());
            fc.write(bf);
        } catch (Exception e) {
            LOG.error("writerFileByRandomAccessFile,Exception:", e);
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFileByFileInputStreamChannel(String fileName) {
        FileChannel fc = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            fc = fis.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(BATCH_SIZE);
            fc.read(bf);
            bf.flip();
            while (bf.hasRemaining()) {
                System.out.print((char) bf.get());
            }
            bf.clear();

        } catch (Exception e) {
            LOG.error("readFileByFileInputStreamChannel,Exception:", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Instances of the following classes are ignored by this rule because close has no effect:
     * <p>
     * java.io.ByteArrayOutputStream
     * java.io.ByteArrayInputStream
     * java.io.CharArrayReader
     * java.io.CharArrayWriter
     * java.io.StringReader
     * java.io.StringWriter
     */
    public static void main(String[] args) {
        String fileName = "data.txt";
        String context = "some .........";
        GetChannel gc = new GetChannel();

        gc.writeFileByFileOutputStream(fileName, context);
        gc.writerFileByRandomAccessFile(fileName, "do some.........");
        gc.readFileByFileInputStreamChannel(fileName);

    }

}
