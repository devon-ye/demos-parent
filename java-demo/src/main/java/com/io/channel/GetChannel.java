package com.io.channel;

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
    private static final int BATCH_SIZE = 1024;


    public void writeFileByFileOutputStream(String filePath, String context) throws IOException {
        FileChannel fc = null;
        try {
            fc = new FileOutputStream(filePath).getChannel();
            ByteBuffer bf = ByteBuffer.wrap(context.getBytes());
            fc.write(bf);
        } finally {
            if (fc != null) {
                fc.close();
            }
        }
    }

    public void writerFileByRandomAccessFile(String fileName, String context) throws IOException {
        FileChannel fc = null;
        try {
            fc = new RandomAccessFile(fileName, "rw").getChannel();
            fc.position();
            ByteBuffer bf = ByteBuffer.wrap(context.getBytes());
            fc.write(bf);

        } finally {
            if (fc != null) {
                fc.close();
            }
        }
    }

    public void readFileByFileInputStreamChannel(String fileName) throws IOException {
        FileChannel fc = null;
        try {
            fc = new FileInputStream(fileName).getChannel();
            ByteBuffer bf = ByteBuffer.allocate(BATCH_SIZE);
            fc.read(bf);
            bf.flip();
            while (bf.hasRemaining()) {
                System.out.print((char) bf.get());
            }
            bf.clear();

        } finally {
            if (fc != null) {
                fc.close();
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "data.txt";
        String context = "some .........";
        GetChannel gc = new GetChannel();
        try {
            gc.writeFileByFileOutputStream(fileName, context);
            gc.writerFileByRandomAccessFile(fileName, "do some.........");
            gc.readFileByFileInputStreamChannel(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
