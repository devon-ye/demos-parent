package org.devon.algorithm.data.structure.tree;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/5 17:03
 * @since 1.0.0
 */
public interface Tree {

   <T> T get(int index);

    <T> boolean   add(T t);

    void delete(int index);




}
