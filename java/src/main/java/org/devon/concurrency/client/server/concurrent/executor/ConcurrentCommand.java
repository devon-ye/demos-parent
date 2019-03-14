package org.devon.concurrency.client.server.concurrent.executor;

import org.devon.concurrency.client.server.serial.client.Command;

import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:51
 */
public abstract class ConcurrentCommand extends Command implements Runnable,Comparable {
   private Socket socket;
    public ConcurrentCommand(String[] command) {
        super(command);
    }

    @Override
    public abstract String execute();


    @Override
    public void run() {

    }

    public Socket getSocket() {
        return socket;
    }
}
