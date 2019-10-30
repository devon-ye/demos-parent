package org.devon.data.structures.tree;

/**
 * B+ Tree Leaf Node
 * @author dewen.ye
 * @datetime 2019/10/30 10:20 AM
 * @since
 */
public class BTPLeafNode {
    // PAGE_SIZE = k*4[keyw..大小]+k*8[dataAd..大小]+8[prev大小]+8[next大小]
    private int k;
    private Object[] keyWords;
    private Long[] address;

    private BTPLeafNode prev;
    private BTPLeafNode next;


    public BTPLeafNode(int k, Object[] keyWords, Long[] address, BTPLeafNode prev, BTPLeafNode next) {
        this.k = k;
        this.keyWords = keyWords;
        this.address = address;
        this.prev = prev;
        this.next = next;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Object[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(Object[] keyWords) {
        this.keyWords = keyWords;
    }

    public Long[] getAddress() {
        return address;
    }

    public void setAddress(Long[] address) {
        this.address = address;
    }

    public BTPLeafNode getPrev() {
        return prev;
    }

    public void setPrev(BTPLeafNode prev) {
        this.prev = prev;
    }

    public BTPLeafNode getNext() {
        return next;
    }

    public void setNext(BTPLeafNode next) {
        this.next = next;
    }
}
