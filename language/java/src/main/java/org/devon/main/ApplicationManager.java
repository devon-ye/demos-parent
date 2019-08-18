package org.devon.main;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/1 21:10
 * @since 1.0.0
 */
public class ApplicationManager {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        long endTime = 0;
        while (endTime - startTime > 2000) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("ApplicationManager###");
            endTime = System.currentTimeMillis();
        }
    }

}
