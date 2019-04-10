package org.devon.concurrency.client.server.V1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dewen.ye
 * @date 2019/3/3 20:38
 */
public class SerialServer {
    private static final Logger LOG = LoggerFactory.getLogger(SerialServer.class);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line = in.readLine();
            Command command;
            String[] commandData = line.split(";");
            switch (commandData[0]) {
                case "q":
                    LOG.debug("queryCommand:", commandData);
                    command = new QueryCommand(commandData);
                    break;
                case "r":
                    LOG.debug("reportCommand:", commandData);
                    command = new ReportCommand(commandData);
                    break;
                case "z":
                    LOG.debug("reportCommand:", commandData);
                    command = new StopCommand(commandData);
                    break;
                default:
                    LOG.debug("errorCommand:", commandData);
                    command = new ErrorCommand(commandData);
            }
            String result = command.execute();
            LOG.info("command.execute() result:", result);

        } catch (IOException e) {
            LOG.error("");
        }
    }
}
