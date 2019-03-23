package org.devon.concurrency.client.server.serial.client;

/**
 * @author dewen.ye
 * @date 2019/3/3 20:30
 */
public abstract class Command implements Runnable{
    protected final String[] command;
    protected boolean cacheable;

    public Command(String[] command) {
        this.command = command;
    }
    public abstract String execute();

    public boolean isCacheable(){
        return cacheable;
    }

    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }
}
