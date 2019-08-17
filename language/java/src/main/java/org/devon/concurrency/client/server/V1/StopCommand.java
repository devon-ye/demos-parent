package org.devon.concurrency.client.server.V1;


/**
 * @author dewen.ye
 * @date 2019/3/3 20:36
 */
public class StopCommand extends Command {

    public StopCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        return "Server stopped";
    }
}
