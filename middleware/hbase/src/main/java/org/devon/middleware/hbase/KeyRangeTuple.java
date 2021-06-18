package org.devon.middleware.hbase;

/**
 * @author dewen.ye
 * @datetime 2019/10/28 4:22 PM
 * @since
 */
public class KeyRangeTuple {
    private String startKey;
    private String stopKey;
    private int  rowSize;

    public KeyRangeTuple(String startKey, String stopKey) {
        this.startKey = startKey;
        this.stopKey = stopKey;
    }

    public KeyRangeTuple(String startKey, String stopKey, int rowSize) {
        this.startKey = startKey;
        this.stopKey = stopKey;
        this.rowSize = rowSize;
    }

    public String getStartKey() {
        return startKey;
    }

    public void setStartKey(String startKey) {
        this.startKey = startKey;
    }

    public String getStopKey() {
        return stopKey;
    }

    public void setStopKey(String stopKey) {
        this.stopKey = stopKey;
    }

    public int getRowSize() {
        return rowSize;
    }

    public void setRowSize(int rowSize) {
        this.rowSize = rowSize;
    }

    @Override
    public String toString() {
        return "KeyRangeTuple{" +
                "startKey='" + startKey + '\'' +
                ", stopKey='" + stopKey + '\'' +
                ", rowSize=" + rowSize +
                '}';
    }
}
