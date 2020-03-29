package org.devon.data.structures.graph;

/**
 * @author Devonmusa
 * @date 2019/8/18 17:53
 * @since
 */
public interface Graph {


	void addVertex(Vertex vertex);

	void addEdge(Edge edge);

	int degree(Graph graph, int v);

	int maxDegree();

	int vertexCount();

	int edgeCount();


}
