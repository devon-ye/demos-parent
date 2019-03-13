package org.devon.concurrency.client.server.concurrent.service;

import org.devon.concurrency.client.server.serial.client.Command;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:51
 */
public class ConcurrentCommand extends Command {

    public ConcurrentCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        return null;
    }


}
