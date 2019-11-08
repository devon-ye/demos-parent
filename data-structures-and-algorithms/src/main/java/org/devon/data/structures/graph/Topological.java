package org.devon.data.structures.graph;

/**
 * @author dewen.ye
 * @datetime 2019/11/8 11:27 PM
 * @since
 */
public interface Topological {

	boolean  isDAG();

	Iterable<Integer> order();
}
