package org.devon.concurrency.client.server.V1;

/**
 * @author dewen.ye
 * @date 2019/3/3 20:30
 */
public abstract class Command{
    protected final String[] command;

    public Command(String[] command) {
        this.command = command;
    }
    public abstract String execute();

}
