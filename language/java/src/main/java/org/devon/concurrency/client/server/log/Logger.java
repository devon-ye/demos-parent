package org.devon.concurrency.client.server.log;


import java.io.BufferedWriter;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author dewen.ye
 * @date 2019/3/13 08:38
 */
public class Logger {
    private static ConcurrentLinkedQueue<String> logQueue = new ConcurrentLinkedQueue<>();
    private static Thread thread;
    private static final String LOG_FILE = Paths.get("output","server.log").toString();

    static {
        LogTask task = new LogTask();
        thread = new Thread(task);
    }

    public static void sendMessage(String message){
        logQueue.offer(new Date() +": " + message);
    }

    public static void writeLogs(){
        String message;
        Path path = Paths.get(LOG_FILE);
        try (BufferedWriter fileWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND)){
            while ((message = logQueue.poll())!= null){
                fileWriter.write(message);
                fileWriter.newLine();
            }

        }catch (Exception e){

        }
    }

    public static void initializedLog(){
        Path path = Paths.get(LOG_FILE);
        if(Files.exists(path)){
            try (OutputStream out = Files.newOutputStream(path, StandardOpenOption.TRUNCATE_EXISTING)){

            }catch (Exception e){

            }
        }
        thread.start();
    }

    public static void shutDown(){
        thread.interrupt();
    }
}
