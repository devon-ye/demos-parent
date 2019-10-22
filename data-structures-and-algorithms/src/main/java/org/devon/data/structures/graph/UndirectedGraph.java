package org.devon.data.structures.graph;

import org.devon.data.structures.Node;

public class UndirectedGraph extends AbstractGraph {
    /**
     * 顶点数
     */
    private int vertexCount;
    /**
     * 边数
     */
    private int edgeCount;
    /**
     * 邻接表
     * ｜A｜-->|C|-->|D|-->|E|
     * ｜B｜-->||-->||
     * ｜C｜-->||-->||-->||-->||
     * ｜D｜-->||-->||
     * ｜E｜-->||
     */
    private Node[]  adj;

    public UndirectedGraph() {
    }

    @Override
    public void addVertex(Vertex vertex) {

    }

    @Override
    public void addEdge(Edge edge) {

    }

    @Override
    public int degree(Graph graph, int v) {
        return 0;
    }

    @Override
    public int maxDegree() {
        return 0;
    }

    @Override
    public int vertexCount() {
        return 0;
    }

    @Override
    public int edgeCount() {
        return 0;
    }
}
