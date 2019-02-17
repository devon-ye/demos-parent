package org.devon.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo on 2017/10/22.
 */
public class JavaDemos {
    private static final Logger LOGGER = LoggerFactory.getLogger("JavaDemos");

    public static void main(String[] args) {

           String language =System.getProperty("user.language");
           String region = System.getProperty("user.region");
            System.out.println("this java-demos.exe");

            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    try {

                        System.out.println("programe exedute end!");
                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                }
            });
    }
}
