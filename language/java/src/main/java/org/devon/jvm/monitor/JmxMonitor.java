package org.devon.jvm.monitor;

import jdk.nashorn.internal.ir.WhileNode;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.List;

/**
 * Created by lenovo on 2017/10/15.
 */
public class JmxMonitor {


    public static void main(String[] args) throws InterruptedException {
        //-Xms4G -Xmx4G -Xss3m
        System.setProperty("-XX:InitialHeapSize","4G");
       System.setProperty("-XX:MaxHeapSize","4G");
      System.setProperty("-XX:ThreadStackSize","3M");

        System.out.println(System.getenv());
        System.out.println("---------------------------------------------------------");
        System.out.println(System.getProperties());
        System.out.println("---------------------------------------------------------");

        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = tmb.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {

            System.out.println("threadInfo: " + threadInfo.getThreadId() + ",name=" + threadInfo.getThreadName() + ",status=" + threadInfo.getThreadState());
        }

        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        List<MemoryManagerMXBean> memoryManagerMXBeanList = ManagementFactory.getMemoryManagerMXBeans();
        for (MemoryManagerMXBean memoryManagerMXBean : memoryManagerMXBeanList) {
            System.out.println("MemoryManager name:" + memoryManagerMXBean.getName() + ",isValid:" + memoryManagerMXBean.isValid());
            String[] memoryPoolNames = memoryManagerMXBean.getMemoryPoolNames();
            for (int i = 0; i < memoryPoolNames.length; i++) {
                System.out.println("          memory pool name:" + memoryPoolNames[i]);
            }
        }

        System.out.println();
        while (true) Thread.sleep(1000);
    }




}
