package org.devon.data.structures.tree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Devonmusa
 * @date 2019/8/24 5:00
 * @since
 */
public class BinaryTreeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        BinaryTree binaryTree = new BinaryTree();

        Assert.assertTrue(binaryTree.size()==0);

        binaryTree.put(new Double(1),1);
        binaryTree.put(new Double(3),2);
        binaryTree.put(new Double(5),4);
        Assert.assertTrue(binaryTree.size()==3);

    }

    @Test
    public void size1() {
    }

    @Test
    public void get() {
    }

    @Test
    public void put() {
    }

    @Test
    public void min() {
    }

    @Test
    public void max() {
    }

    @Test
    public void preOrderTraversal() {
    }

    @Test
    public void inOrderIterator() {
    }

    @Test
    public void postOrderIterator() {
    }

    @Test
    public void preOrderTraversal1() {
    }
}