package com.io.character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWriterReader {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("d://1.txt");
            br = new BufferedReader(fr);

            String str;
            int line = 1;
            while ((str = br.readLine()) != null) {
                System.out.println(line + ":" + str);
                line++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
