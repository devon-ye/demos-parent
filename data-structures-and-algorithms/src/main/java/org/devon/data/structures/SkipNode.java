package org.devon.data.structures;

public class SkipNode<E> {

    private E data;
    private SkipNode[] forwards = new SkipNode[Integer.MAX_VALUE];
    private int maxLevel;

    public SkipNode(E data,  int maxLevel) {
        this.data = data;
        this.maxLevel = maxLevel;
        this.forwards = new SkipNode[maxLevel];
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public SkipNode[] getForwards() {
        return forwards;
    }

    public void setForwards(SkipNode[] forwards) {
        this.forwards = forwards;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}
