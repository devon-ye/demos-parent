package org.devon.concurrency.search.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * @author dewen.ye
 * @date 2019/2/19 22:33
 */
public class ParallelGroupFileSearch {
    private static final Logger LOG = LoggerFactory.getLogger(ParallelGroupFileSearch.class);
    private static ConcurrentLinkedQueue<File> directoriesQueue = new ConcurrentLinkedQueue<>();


    public static void searchFiles(File file, String fileName, Result result) {
        int processorsSize = Runtime.getRuntime().availableProcessors();
        directoriesQueue.add(file);
        for (int i = 0; i < processorsSize; i++) {
            ParallelGroupFileTask task = new ParallelGroupFileTask(directoriesQueue, fileName, result);
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
        Queue<File> directoriesQueue;
        String fileName;
        Result result;

        public ParallelGroupFileTask(Queue<File> directoriesQueue, String fileName, Result result) {
            this.directoriesQueue = directoriesQueue;
            this.fileName = fileName;
            this.result = result;
        }

        @Override
        public void run() {
            while (directoriesQueue.size() > 0) {
                File file = this.directoriesQueue.poll();
                processDirectory(file, fileName, result);
            }
        }


        private void processDirectory(File file, String fileName, Result parallelResult) {
            File[] contents = file.listFiles();
            if (contents == null || contents.length == 0) {
                return;
            }
            for (File content : contents) {
                if (content.isDirectory()) {
                    processDirectory(content, fileName, parallelResult);
                } else {
                    processFile(content, fileName, parallelResult);
                }
            }
        }

        private void processFile(File content, String fileName, Result parallelResult) {
            if (fileName.equals(content.getName())) {
                parallelResult.setFilePath(content.getAbsolutePath());
                parallelResult.setFound(true);
                directoriesQueue.clear();
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
