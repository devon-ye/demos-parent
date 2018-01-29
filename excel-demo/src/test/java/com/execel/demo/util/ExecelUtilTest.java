package com.execel.demo.util;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date ${date} ${time}
 */
public class ExecelUtilTest {
    @Test
    public void createExecel() throws Exception {
    }

    @Test
    public void createExecelWithbytes() throws Exception {

        ByteArrayOutputStream bos = null;
        FileOutputStream outputStreamWriter = null;

        try {
            File file = new File("/develop/测试2.xls");
            outputStreamWriter = new FileOutputStream(file);
            String[] headers = new String[]{"列名称１", "类名称２", "lei"};
            byte[] bytes = ExecelUtil.createExecelWithbytes("sheee1", headers);
            outputStreamWriter.write(bytes);
            outputStreamWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStreamWriter.close();
        }
    }

    @Test
    public void createExecelTemplateById() throws Exception {
    }

}