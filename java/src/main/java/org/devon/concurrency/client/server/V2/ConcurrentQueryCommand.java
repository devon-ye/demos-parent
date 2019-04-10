package org.devon.concurrency.client.server.V2;

import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/4/10 08:53
 */
public class ConcurrentQueryCommand extends ConcurrentCommand {

    public ConcurrentQueryCommand(String[] command) {
        super(null,command);
    }

    public ConcurrentQueryCommand(Socket socket, String[] command) {
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
