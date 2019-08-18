package org.devon.jdbc;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by lenovo on 2017/10/13.
 */
public class DatabaseConnectPool {
    private LinkedList<Connection> connectPool = new LinkedList<>();

    public DatabaseConnectPool(int initialSize) {
        for(int i = 0; i < initialSize;i++) {
            connectPool.add(ConnectionDriver.createConnection());
        }

    }

    public void releaseConnection(Connection connection) {
        if(connection != null) {
            synchronized (connectPool) {
                connectPool.addLast(connection);
                connectPool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (connectPool) {
            if(mills < 0) {
                while (connectPool.isEmpty()){
                    connectPool.wait();
                }
                return connectPool.removeFirst();
            }else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (connectPool.isEmpty() && remaining > 0) {
                    connectPool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;

                if(!connectPool.isEmpty()) {
                    result  = connectPool.removeFirst();
                }

                return result;
            }

        }
    }
}
