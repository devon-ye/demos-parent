package org.devon.concurrency.client.server.V2;


import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/3/14 08:25
 */
public class ConcurrentCancelCommand extends ConcurrentCommand {

    public ConcurrentCancelCommand(Socket socket, String[] command) {
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
