package com.monitor;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by lenovo on 2017/10/15.
 */
public class JmxMonitor {
    public static void main(String[] args) {
        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = tmb.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {

            System.out.println("threadInfo: " + threadInfo.getThreadId() + ",name=" + threadInfo.getThreadName() + ",status=" + threadInfo.getThreadState());
        }
    }

}
