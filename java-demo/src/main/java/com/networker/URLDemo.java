package com.networker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/11/30.
 */
public class URLDemo {
    private static Logger log  = LoggerFactory.getLogger("URLDemo") ;

    public URLDemo() {

    }

    private void getResource() {
        try {

            URL url = new URL("http","www.baidu.com",80,"ss");
            InputStream is= url.openStream();
            URLConnection urlConnection = url.openConnection();
            System.out.println(urlConnection.getContentLength());
            System.out.println(urlConnection.getContentType());
            System.out.println(urlConnection.getPermission());
            Scanner sc = new Scanner(is);
            sc.useDelimiter("/n");
            while (sc.hasNext())
            {
                System.out.println(sc.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void coder() {
        String  keyEncoder = null;
        try {
            keyEncoder = URLEncoder.encode("devon中文","UTF-8");
            System.out.println("encoder after：" +keyEncoder);
            String keyDecoder = URLDecoder.decode(keyEncoder,"utf-8");
            System.out.println("decoder after：" +keyDecoder);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        URLDemo urlDemo = new URLDemo();
        //urlDemo.getResource();
        urlDemo.coder();
    }
}
