package org.devon.concurrency.client.server.concurrent.service;

import org.devon.concurrency.client.server.serial.client.Command;

/**
 * @author dewen.ye
 * @date 2019/3/5 23:48
 */
public class CacheItem {

    private Command command;
    private String commands;
    private String reponse;
    private long createTime;
    private long accessTime;

    public CacheItem(String commands, String reponse) {
        this.commands = commands;
        this.reponse = reponse;
    }

    public long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(long accessTime) {
        this.accessTime = accessTime;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
