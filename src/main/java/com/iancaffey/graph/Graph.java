package com.iancaffey.graph;

import java.util.Collection;
import java.util.Set;

/**
 * Graph
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface Graph<V extends Vertex> {
    public void add(V vertex);

    public void addAll(Collection<? extends V> vertices);

    public void remove(V vertex);

    public void removeAll(Collection<? extends V> vertices);

    public boolean contains(V vertex);

    public Edge<V> connect(V source, V destination, double weight);

    public Edge<V> edge(V source, V destination);

    public void connectBidirectional(V one, V two, double weight);

    public Edge<V> disconnect(V source, V destination);

    public void disconnectBidirectional(V one, V two);

    public Set<V> vertices();

    public Set<Edge<V>> outgoingEdges(V vertex);

    public int outgoingEdgeCount(V vertex);

    public Set<Edge<V>> incomingEdges(V vertex);

    public int incomingEdgeCount(V vertex);
}
