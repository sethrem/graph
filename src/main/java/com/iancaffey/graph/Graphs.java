package com.iancaffey.graph;

import com.iancaffey.graph.util.Distance;

/**
 * Graphs
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Graphs {
    private Graphs() {

    }

    public static <V extends Vertex> Graph<V> newEmptyGraph() {
        return new BaseGraph<>();
    }

    public static <V extends Vertex> V nearest(Graph<V> graph, Vertex vertex, Distance distance) {
        if (vertex == null)
            throw new IllegalArgumentException();
        return Graphs.nearest(graph, vertex.x, vertex.y, vertex.z, distance);
    }

    public static <V extends Vertex> V nearest(Graph<V> graph, double x, double y, Distance distance) {
        return Graphs.nearest(graph, x, y, 0, distance);
    }

    public static <V extends Vertex> V nearest(Graph<V> graph, double x, double y, double z, Distance distance) {
        if (graph == null || distance == null)
            throw new IllegalArgumentException();
        double minDistance = Double.MAX_VALUE;
        V minVertex = null;
        for (V vertex : graph.vertices()) {
            double d = distance.between(vertex, x, y, z);
            if (minDistance > d) {
                minDistance = d;
                minVertex = vertex;
            }
        }
        return minVertex;
    }
}
