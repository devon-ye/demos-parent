package org.devon.concurrency.client.server.V2;

/**
 * @author dewen.ye
 * @date 2019/3/5 23:48
 */
public class CacheItem {

    private Command command;
    private String commands;
    private String response;
    private long createTime;
    private long accessTime;

    public CacheItem(String commands, String response) {
        this.commands = commands;
        this.response = response;
    }

    public long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(long accessTime) {
        this.accessTime = accessTime;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String reponse) {
        this.response = reponse;
    }
}
