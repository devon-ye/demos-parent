package org.devon.concurrency.client.server.concurrent.client;

import org.devon.concurrency.client.server.concurrent.executor.ConcurrentCommand;

import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/3/14 08:44
 */
public class ConcurrentRepotCommand extends ConcurrentCommand {

    public ConcurrentRepotCommand(Socket socket, String[] command) {
        super(socket, command);
    }

    @Override
    public String execute() {
        return null;
    }

    @Override
    public int compareTo(ConcurrentCommand o) {
        return 0;
    }
}
