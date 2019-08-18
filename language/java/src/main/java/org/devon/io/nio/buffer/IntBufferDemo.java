package org.devon.io.nio.buffer;

import java.nio.IntBuffer;

/**
 * Created by lenovo on 2017/12/2.
 */
public class IntBufferDemo {
    private IntBuffer intBuffer = null;


    public void intBufferDemo() {
        intBuffer = IntBuffer.allocate(7);
        System.out.println("write before  position:" + intBuffer.position() + ",limit:" + intBuffer.limit() + ",capacity:" + intBuffer.capacity());
        int[] temp = {1, 21312, 3123, 324, 234, 5345};
        intBuffer.put(5);
        intBuffer.put(temp);

        System.out.println("write after  position:" + intBuffer.position() + ",limit:" + intBuffer.limit() + ",capacity:" + intBuffer.capacity());

        intBuffer.flip();
        System.out.println("write flip  position:" + intBuffer.position() + ",limit:" + intBuffer.limit() + ",capacity:" + intBuffer.capacity());
        System.out.println("print buffer content:");
        while (intBuffer.hasRemaining()) {
            System.out.println("x:" + intBuffer.get());
        }


    }

    public static void main(String[] args) {
        IntBufferDemo intBufferDemo = new IntBufferDemo();
       intBufferDemo.intBufferDemo();
    }
}
