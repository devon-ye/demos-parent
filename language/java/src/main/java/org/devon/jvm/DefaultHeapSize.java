package org.devon.jvm;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/1/17 12:58 PM
 */
public class DefaultHeapSize {

    public static void main(String[] args) {
         getDefaultHeapSize();
    }

    public static Long getDefaultHeapSize() {
        long low = 0;
        long height = Integer.MAX_VALUE;
        long mid = (low + height) / 2;
        long defaultHeapSize = low;
        while (low <= height) {
            for (int i = 0; i <=10; i++) {
                try {
                    char[] c = new char[(int) mid];
                    defaultHeapSize = mid;
                    low = mid + 1;
                    mid = (low + height) / 2;
                    System.out.println("第" + i + "次申请成功内存 大小:" + defaultHeapSize + " bytes");
                    break;
                } catch (OutOfMemoryError e) {
                    if (i == 10) {
                        System.out.println("申请失败:" + mid);
                        height = mid - 1;
                        mid = (low + height) / 2;
                    }
                }
            }
        }
        System.out.println("可申请的最大内存:"+defaultHeapSize);
        return defaultHeapSize;
    }
}
