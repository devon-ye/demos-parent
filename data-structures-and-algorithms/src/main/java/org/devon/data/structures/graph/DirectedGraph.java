package org.devon.data.structures.graph;

/**
 * @author Devonmusa
 * @date 2019/8/20 0:35
 * @since
 */
public class DirectedGraph extends AbstractGraph{

    /**
     * |---|---|---|
     * | A | B | C |
     * |---|---|---|
     */

    private Vertex[] vertices;

    /**
     * 邻接矩阵
     * * *A  B  C
     * *|---------|
     * A| 1  0  0 |
     * B| 0  1  0 |
     * C| 0  0  1 |
     * *|---------|
     */
    private Object[][] matrix;


    public DirectedGraph(int vertexSize) {
        this.vertices = new Vertex[vertexSize];
        this.matrix = new Object[vertexSize][vertexSize];
        init();
    }

    private void init() {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }
    }


    public void addVertex(Vertex vertex) {

    }

    public void addEdge(Edge edge) {

    }


    public int degree(Graph graph, int v){
        return 0;
    }

    public int maxDegree(){
        return 0;
    }

    public int vertexCount(){
        return 0;
    }

    public int edgeCount(){
        return 0;
    }
}
