package org.devon.concurrency.client.server.V2;

import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/4/10 08:58
 */
public class ConcurrentStopCommand extends ConcurrentCommand {

    public ConcurrentStopCommand(String[] command) {
     super(null,command);
    }

    public ConcurrentStopCommand(Socket socket, String[] command) {
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
