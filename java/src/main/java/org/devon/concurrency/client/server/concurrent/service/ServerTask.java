package org.devon.concurrency.client.server.concurrent.service;

import org.devon.concurrency.client.server.serial.client.Command;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:49
 */
public class ServerTask<T>  implements Runnable{
    private ConcurrentCommand command;
    @Override
    public void run() {

    }

    public ConcurrentCommand getCommand() {
        return command;
    }


    public boolean isCancelled(){
        return false;
    }
}
