package org.devon.concurrency.client.server.V3;


import org.devon.concurrency.client.server.V2.Command;
import org.devon.concurrency.client.server.V2.ConcurrentErrorCommand;
import org.devon.concurrency.client.server.V2.ConcurrentQueryCommand;
import org.devon.concurrency.client.server.V2.ConcurrentRepotCommand;
import org.devon.concurrency.client.server.V2.ConcurrentServer;
import org.devon.concurrency.client.server.V2.ConcurrentStatusCommand;
import org.devon.concurrency.client.server.V2.ConcurrentStopCommand;
import org.devon.concurrency.client.server.V2.ParallelCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/3/3 21:10
 */
public class RequestTask implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(RequestTask.class);
    private final Socket clientSocket;

    public RequestTask(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            String line = in.readLine();
            ParallelCache cache = ConcurrentServer.getCache();
            String ret = cache.get(line);
            if (ret == null) {
                Command command;
                String[] commandData = line.split(";");
                switch (commandData[0]) {
                    case "q":
                        LOG.debug("queryCommand:", commandData);
                        command = new ConcurrentQueryCommand(commandData);
                        break;
                    case "r":
                        LOG.debug("reportCommand:", commandData);
                        command = new ConcurrentRepotCommand(commandData);
                        break;
                    case "s":
                        LOG.debug("reportCommand:", commandData);
                        command = new ConcurrentStatusCommand(commandData);
                        break;
                    case "z":
                        LOG.debug("reportCommand:", commandData);
                        command = new ConcurrentStopCommand(commandData);
                        break;
                    default:
                        LOG.debug("errorCommand:", commandData);
                        command = new ConcurrentErrorCommand(commandData);
                }
                ret = command.execute();
                if (command.isCacheable()) {
                    cache.put(line, ret);
                }
                LOG.info("command.execute() result:", ret);
            }
        } catch (Exception e) {
            LOG.error("Exception:", e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                LOG.error("clentSocket.close(),IOException:", e);
            }
        }
    }


}
