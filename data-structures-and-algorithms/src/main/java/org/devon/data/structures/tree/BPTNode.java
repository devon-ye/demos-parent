package org.devon.data.structures.tree;

/**
 *  B+ tree node 非叶子节点
 * @author dewen.ye
 * @datetime 2019/10/30 9:01 AM
 * @since
 */
public class BPTNode {
    /**
     * m值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
     * PAGE_SIZE = (m-1)*4[keywordss大小]+m*8[children大小]
     */
    private int m;

    private Object[] keyWords;

    private  BPTNode[] childrens;


    public BPTNode(int m) {
        this.m = m;
        this.keyWords = new Object[m];
        this.childrens = new BPTNode[m];
    }
}
