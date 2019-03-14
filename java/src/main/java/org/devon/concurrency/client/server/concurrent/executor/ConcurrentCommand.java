package org.devon.concurrency.client.server.concurrent.executor;

import org.devon.concurrency.client.server.concurrent.service.ConcurrentServer;
import org.devon.concurrency.client.server.concurrent.service.ParallelCache;
import org.devon.concurrency.client.server.log.Logger;
import org.devon.concurrency.client.server.serial.client.Command;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:51
 */
public abstract class ConcurrentCommand extends Command implements Runnable, Comparable<ConcurrentCommand> {
    private Socket socket;
    private String userName;
    private byte priority;

    public ConcurrentCommand(Socket socket, String[] command) {
        super(command);
        priority = Byte.parseByte(command[2]);
        this.socket = socket;
    }

    @Override
    public abstract String execute();


    @Override
    public void run() {
        String message = "Running  a Task  UserName:" + userName + ",priority:" + priority;
        Logger.sendMessage(message);

        String ret = execute();

        ParallelCache cache = ConcurrentServer.getCache();

        if (isCacheable()) {
            cache.put(String.join(";", command), ret);
        }

        try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println(ret);
        } catch (Exception e) {

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUserName() {
        return userName;
    }
}
