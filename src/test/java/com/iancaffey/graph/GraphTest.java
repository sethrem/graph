package com.iancaffey.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * GraphTest
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class GraphTest {
    @Test
    public void addTest() {
        Graph<Vertex> graph = Graphs.newEmptyGraph();
        Vertex vertex = new Vertex();
        graph.add(vertex);
        Assert.assertTrue(graph.contains(vertex));
    }

    @Test
    public void removeTest() {
        Graph<Vertex> graph = Graphs.newEmptyGraph();
        Vertex vertex = new Vertex();
        graph.add(vertex);
        Assert.assertTrue(graph.contains(vertex));
        graph.remove(vertex);
        Assert.assertFalse(graph.contains(vertex));
    }

    @Test
    public void connectTest() {
        Graph<Vertex> graph = Graphs.newEmptyGraph();
        Vertex one = new Vertex(123, 456, 0);
        Vertex two = new Vertex(321, 654, 0);
        double weight = 14.5;
        graph.add(one);
        graph.add(two);
        Edge<Vertex> edge = graph.connect(one, two, weight);
        Assert.assertNotNull(edge);
        Assert.assertSame(edge.source, one);
        Assert.assertSame(edge.destination, two);
        Assert.assertEquals(edge.weight, weight, 0);
        Edge<Vertex> foundEdge = graph.edge(one, two);
        Assert.assertEquals(edge, foundEdge);
    }
}
