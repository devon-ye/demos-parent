package org.devon.concurrency.search.file;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author dewen.ye
 * @date 2019/2/19 22:33
 */
public class ParallelGroupFileSearch {

    private static ConcurrentLinkedQueue<String> filePathQueue = new ConcurrentLinkedQueue<>();


    public static void searchFile(File file, String fileName, Result result) {
        int processorsSize = Runtime.getRuntime().availableProcessors();
        filePathQueue.add(file.getAbsolutePath());
        for (int i = 0; i < processorsSize; i++) {
            ParallelGroupFileTask task = new ParallelGroupFileTask(filePathQueue, fileName, result);
            Thread thread = new Thread(task);
            thread.start();
        }
        while (!result.isFound()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ParallelGroupFileTask implements Runnable {
        Queue<String> filePathQueue;
        String fileName;
        Result result;

        public ParallelGroupFileTask(Queue<String> filePathQueue, String fileName, Result result) {
            this.filePathQueue = filePathQueue;
            this.fileName = fileName;
            this.result = result;
        }

        @Override
        public void run() {
            while (filePathQueue.size() > 0) {
                String filePath = this.filePathQueue.poll();
               // System.out.println("filePath:"+filePath);
                File file = new File(filePath);
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    if(files==null){
                        continue;
                    }
                    for (File file1 : files) {
                        this.filePathQueue.offer(file1.getAbsolutePath());
                    }
                } else {
                    if (fileName.equals(file.getName())) {
                        result.setFilePath(file.getAbsolutePath());
                        result.setFound(true);
                        filePathQueue.clear();
                    }
                }
            }
        }
    }

    static class Result {
        boolean found;
        String filePath;

        public boolean isFound() {
            return found;
        }

        public void setFound(boolean found) {
            this.found = found;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
    }


}
