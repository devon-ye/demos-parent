package org.devon.concurrency.client.server.V1.dao;

/**
 * @author dewen.ye
 * @date 2019/4/10 08:46
 */
public interface Dao {
    
    String query(String sql,String args);
}
