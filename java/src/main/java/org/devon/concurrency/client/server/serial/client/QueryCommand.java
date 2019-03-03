package org.devon.concurrency.client.server.serial.client;

import org.devon.concurrency.client.server.serial.client.Command;

/**
 * @author dewen.ye
 * @date 2019/3/3 20:31
 */
public class QueryCommand extends Command {


    public QueryCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
      return "query command";
    }
}
