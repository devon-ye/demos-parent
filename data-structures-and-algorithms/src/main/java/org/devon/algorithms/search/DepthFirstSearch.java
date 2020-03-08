package org.devon.algorithms.search;

import org.devon.data.structures.graph.Graph;
import org.devon.data.structures.graph.Vertex;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:33
 * @since 1.0.0
 */
public class DepthFirstSearch {

	private Boolean[] marked;
	private int count;


	public DepthFirstSearch(Graph graph, int s) {
		marked = new Boolean[graph.vertexCount()];
	}

	private void dfs(Graph graph,int v){
		marked[v] = true;
		count++;
		//for (int w: graph.addVertex(new Vertex(v,null));)
	}
}
