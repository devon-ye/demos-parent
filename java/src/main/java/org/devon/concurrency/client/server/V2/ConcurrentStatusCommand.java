package org.devon.concurrency.client.server.V2;

import org.devon.concurrency.client.server.concurrent.service.ConcurrentServer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dewen.ye
 * @date 2019/3/3 21:27
 */
public class ConcurrentStatusCommand extends Command {

    public ConcurrentStatusCommand(String[] command) {
        super(command);
        setCacheable(false);
    }

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        ThreadPoolExecutor executor = ConcurrentServer.getExecutor();
        return sb.toString();
    }

    @Override
    public void run() {

    }
}
