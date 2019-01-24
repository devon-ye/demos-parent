package org.devon.distributed.demo.service.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dewen.ye
 * @date 2019/1/24 00:32
 */
//TODO
public class DataBaseStoreDiscovery implements ServiceDiscovery, Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(DataBaseStoreDiscovery.class);
    private ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1, new NameThreadFactory());

    private final String INIT_TABLE_SQL = "create table jdbc_service_discover(" +
            "cluster_name varchar(256) NOT NULL," +
            "own_addr varchar(256) NOT NULL," +
            "heat_beta Timestamp NOT NULL," +
            "ping_data varchar(3000)" +
            ")";
    private final String INSERT_HEAT_BEAT_SQL = "";
    private final String DELETE_LAST_RECORD_SQL = "";
    private final long DELETE_HEAT_BEAT_MS = 5000;

    private Connection connect;

    private long heatBeta;

    public DataBaseStoreDiscovery(Connection connect) {

        this.connect = connect;
    }

    public void init() throws Exception {
        try (Statement statement = connect.createStatement()) {
            statement.execute(INIT_TABLE_SQL);
        } catch (Exception e) {
            throw new Exception("jdbc_service_discovery table init fail!");
        }
        executor.scheduleAtFixedRate(new DataBaseStoreDiscovery(connect), 5, DELETE_HEAT_BEAT_MS, TimeUnit.MICROSECONDS);
    }

    @Override
    public void run() {
        try (Statement statement = connect.createStatement()) {
            statement.execute(DELETE_LAST_RECORD_SQL);
            statement.execute(INSERT_HEAT_BEAT_SQL);
        } catch (Exception e) {
            LOG.warn("heat beat execute fail! Exception:", e);
        }
    }


    static class NameThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        NameThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "heat-beat-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }


}
