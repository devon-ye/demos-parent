package org.devon.data.structures;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * @author devonmusa
 * @description:
 * @since
 */
public class Hash {

    private Object[] data;


    public static void main(String[] args) {
        int[] array = new int[10];

        Node node = new Node(1);

        System.out.println("arrary address:" + array);
        System.out.println("node address:" + node);
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println("heapMemoryUsage：" + heapMemoryUsage);
        System.out.println("nonHeapMemoryUsage:" + nonHeapMemoryUsage);

        while (true){
            try {
                Thread.sleep(20, 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
