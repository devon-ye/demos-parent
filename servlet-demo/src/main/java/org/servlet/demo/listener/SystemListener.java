package org.servlet.demo.listener;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemListener implements Runnable {
    volatile double currentLoad = -1;
    
    @Override
    public void run() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        currentLoad = operatingSystemMXBean.getSystemLoadAverage();

    }
}
