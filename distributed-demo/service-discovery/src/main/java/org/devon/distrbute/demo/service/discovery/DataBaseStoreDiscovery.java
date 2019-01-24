package org.devon.distrbute.demo.service.discovery;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author dewen.ye
 * @date 2019/1/24 00:32
 */
//TODO
public class DataBaseStoreDiscovery implements ServiceDiscovery ,Runnable{
    private final String INIT_TABLE_SQL = "create table jdbc_service_discover(" +
            "cluster_name varchar(256) NOT NULL," +
            "own_addr varchar(256) NOT NULL," +
            "heat_beta Timestamp NOT NULL,"+
            "ping_data varchar(3000)" +
            ")";
    private final String INSERT_HEATBEAT_SQL ="";
    private final String  DELETE_OFFLINE_SQL="";

    private Connection connect;

    public DataBaseStoreDiscovery(Connection connect) {
        this.connect = connect;
    }
    public void init() throws Exception {
        try (Statement statement = connect.createStatement()) {
            statement.execute(INIT_TABLE_SQL);
        }catch (Exception e){
            throw new Exception("jdbc_service_discovery table init fail!");
        }
    }


    @Override
    public void run() {

    }


}
