package org.devon.concurrency.search.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/19 22:20
 */
public class SerialFileSearchTest {

    @Test
    public void searchFiles() {
        SerialFileSearch.Result result = new SerialFileSearch.Result();
        String projectPath = System.getProperty("user.dir");
        //String projectPath = "D:/";
        File file = new File(projectPath);
        long startTime = System.currentTimeMillis();
        SerialFileSearch.searchFiles(file, "SerialFileSearch.java", result);
        long endTime = System.currentTimeMillis();
        Assert.assertEquals(true,result.isFound());
        System.out.println("searchFile costTime:" + (endTime - startTime));

    }
}