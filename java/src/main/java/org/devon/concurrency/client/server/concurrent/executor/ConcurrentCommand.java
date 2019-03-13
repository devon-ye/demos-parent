package org.devon.concurrency.client.server.concurrent.executor;

import org.devon.concurrency.client.server.serial.client.Command;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:51
 */
public abstract class ConcurrentCommand extends Command implements Runnable {

    public ConcurrentCommand(String[] command) {
        super(command);
    }

    @Override
    public abstract String execute();


    @Override
    public void run() {

    }
}
