package org.devon.concurrency.client.server.V1;


/**
 * @author dewen.ye
 * @date 2019/3/3 20:37
 */
public class ErrorCommand extends Command {

    public ErrorCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        return null;
    }
}
