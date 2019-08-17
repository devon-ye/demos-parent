package org.devon.io;

import java.io.*;

/**
 * Created by lenovo on 2017/11/8.
 */
public class Redircting {

    public static void main(String[] args) {
        try {
            redirct();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void redirct() throws IOException {

        PrintStream cosole  = System.out;

        InputStream is = new FileInputStream(Redircting.class.getName());
        BufferedInputStream in  = new BufferedInputStream(is);

        OutputStream os = new FileOutputStream("test.out");
        PrintStream out = new PrintStream(os);
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        Reader rd = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(rd);
        String str = null;
        while ((str=br.readLine()) != null)
        {
            System.out.println(str);
        }
        out.close();
        System.setOut(cosole);
    }
}
