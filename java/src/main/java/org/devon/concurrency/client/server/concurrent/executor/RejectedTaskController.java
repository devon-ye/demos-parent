package org.devon.concurrency.client.server.concurrent.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:35
 */
public class RejectedTaskController implements RejectedExecutionHandler {
    private static Logger LOG = LoggerFactory.getLogger(RejectedTaskController.class);

    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        ConcurrentCommand command = (ConcurrentCommand) task;
        try (Socket clientSocket = command.getSocket();
             PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);) {
            String message = "The Server is shutting down. Your request can not be served." +
                    " Shutting down: " + String.valueOf(executor.isShutdown()) +
                    ". Terminated: " + String.valueOf(executor.isTerminated()) +
                    ". Terminating: " + String.valueOf(executor.isTerminating());

            System.out.println(message);
        } catch (Exception e) {
            LOG.error("server ExceptionL:", e);
        }
    }
}
