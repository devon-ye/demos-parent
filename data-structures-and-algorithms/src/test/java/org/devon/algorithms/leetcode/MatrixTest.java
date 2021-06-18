package org.devon.algorithms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MatrixTest {
    private Matrix matrix;

    @Before
    public void setUp() throws Exception {
        matrix = new Matrix();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void rotate() {
    }

    @Test
    public void searchMatrix() {
    }

    @Test
    public void uniquePaths() {
        matrix.uniquePaths(2,5);
        matrix.uniquePaths(4,5);
    }

    @Test
    public void main() {
    }
}