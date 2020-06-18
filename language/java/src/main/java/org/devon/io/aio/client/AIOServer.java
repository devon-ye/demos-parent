package org.devon.io.aio.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/5/11 4:17 PM
 * @description
 */
public class AIOServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AIOServer.class);
    private final int port;

    public AIOServer(int port) {
        this.port = port;
        listen();
    }

    private void listen() {
        try {
            int processors = Runtime.getRuntime().availableProcessors();
            ExecutorService executorService = new ThreadPoolExecutor(processors, processors * 2, 3000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1000), Executors.defaultThreadFactory());
            AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, processors);
            AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
            serverSocketChannel.bind(new InetSocketAddress(port));
            LOGGER.info(" server start port:{}", port);
            serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                final ByteBuffer buffer = ByteBuffer.allocate(1024);

                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    buffer.clear();
                    try {
                        result.read(buffer).get();
                        buffer.flip();
                        result.write(buffer);
                        buffer.clear();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, Object attachment) {

                }
            });

        } catch (Exception e) {

        }

    }


}
