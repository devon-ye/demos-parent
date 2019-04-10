package org.devon.concurrency.client.server.V2;

import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/4/10 09:00
 */
public class ConcurrentErrorCommand extends ConcurrentCommand {

    public ConcurrentErrorCommand(String[] command) {
        super(null,command);
    }

    public ConcurrentErrorCommand(Socket socket, String[] command) {
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
