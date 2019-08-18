package org.devon.concurrency.search.file;

import java.io.File;

/**
 * @author dewen.ye
 * @date 2019/2/19 22:13
 */
public class SerialFileSearch {


    public static void searchFiles(File file, String fileName, Result result) {
        File[] content = file.listFiles();
        if (content == null || content.length == 0) {
            return;
        }

        for (File fileContent : content) {
            if (fileContent.isDirectory()) {
                searchFiles(fileContent, fileName, result);
            } else {
                if (fileName.equals(fileContent.getName())) {
                    result.setFilePath(fileContent.getAbsolutePath());
                    result.setFound(true);
                    return;
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
