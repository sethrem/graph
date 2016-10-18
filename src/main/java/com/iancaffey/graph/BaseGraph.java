package com.iancaffey.graph;

import java.util.*;

/**
 * BaseGraph
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BaseGraph<V extends Vertex> implements Graph<V> {
    private final Map<V, VertexHub<V>> hubs = new HashMap<>();

    @Override
    public void add(V vertex) {
        if (vertex == null)
            throw new IllegalArgumentException();
        hubs.put(vertex, new VertexHub<>());
    }

    @Override
    public void addAll(Collection<? extends V> vertices) {
        if (vertices == null)
            throw new IllegalArgumentException();
        vertices.forEach(this::add);
    }

    @Override
    public void remove(V vertex) {
        if (vertex == null)
            throw new IllegalArgumentException();
        hubs.remove(vertex);
    }

    @Override
    public void removeAll(Collection<? extends V> vertices) {
        if (vertices == null)
            throw new IllegalArgumentException();
        vertices.forEach(this::remove);
    }

    @Override
    public boolean contains(V vertex) {
        return hubs.containsKey(vertex);
    }

    @Override
    public Edge<V> connect(V source, V destination, double weight) {
        if (source == null || destination == null || weight < 0)
            throw new IllegalArgumentException();
        VertexHub<V> sourceHub = findOrCreate(source);
        VertexHub<V> destinationHub = findOrCreate(destination);
        Edge<V> edge = new Edge<>(source, destination, weight);
        sourceHub.outgoing.put(destination, edge);
        destinationHub.incoming.put(source, edge);
        return edge;
    }

    @Override
    public Edge<V> edge(V source, V destination) {
        if (!hubs.containsKey(source))
            throw new IllegalArgumentException();
        VertexHub<V> hub = hubs.get(source);
        return hub.outgoing.get(destination);
    }

    @Override
    public void connectBidirectional(V one, V two, double weight) {
        if (one == null || two == null)
            throw new IllegalArgumentException();
        VertexHub<V> sourceHub = findOrCreate(one);
        VertexHub<V> destinationHub = findOrCreate(two);
        Edge<V> oneToTwo = new Edge<>(one, two, weight);
        Edge<V> twoToOne = new Edge<>(two, one, weight);
        sourceHub.incoming.put(two, twoToOne);
        sourceHub.outgoing.put(two, oneToTwo);
        destinationHub.incoming.put(one, oneToTwo);
        destinationHub.outgoing.put(one, twoToOne);
    }

    @Override
    public Edge<V> disconnect(V source, V destination) {
        if (source == null || destination == null)
            throw new IllegalArgumentException();
        if (!hubs.containsKey(source))
            return null;
        return hubs.get(source).outgoing.remove(destination);
    }

    @Override
    public void disconnect(Edge<V> edge) {
        if (edge == null)
            throw new IllegalArgumentException();
        disconnect(edge.source, edge.destination);
    }

    @Override
    public void disconnectBidirectional(V one, V two) {
        if (one == null || two == null)
            throw new IllegalArgumentException();
        if (hubs.containsKey(one)) {
            VertexHub<V> oneHub = hubs.get(one);
            oneHub.incoming.remove(two);
            oneHub.outgoing.remove(two);
        }
        if (hubs.containsKey(two)) {
            VertexHub<V> twoHub = hubs.get(two);
            twoHub.incoming.remove(one);
            twoHub.outgoing.remove(one);
        }
    }

    @Override
    public Set<V> vertices() {
        return new HashSet<>(hubs.keySet());
    }

    @Override
    public Set<Edge<V>> outgoingEdges(V vertex) {
        if (vertex == null)
            throw new IllegalArgumentException();
        if (!hubs.containsKey(vertex))
            return Collections.emptySet();
        return new HashSet<>(hubs.get(vertex).outgoing.values());
    }

    @Override
    public int outgoingEdgeCount(V vertex) {
        if (vertex == null)
            throw new IllegalArgumentException();
        if (!hubs.containsKey(vertex))
            return 0;
        return hubs.get(vertex).outgoing.size();
    }

    @Override
    public Set<Edge<V>> incomingEdges(V vertex) {
        if (vertex == null)
            throw new IllegalArgumentException();
        if (!hubs.containsKey(vertex))
            return Collections.emptySet();
        return new HashSet<>(hubs.get(vertex).incoming.values());
    }

    @Override
    public int incomingEdgeCount(V vertex) {
        if (vertex == null)
            throw new IllegalArgumentException();
        if (!hubs.containsKey(vertex))
            return 0;
        return hubs.get(vertex).incoming.size();
    }

    private VertexHub<V> findOrCreate(V vertex) {
        if (hubs.containsKey(vertex))
            return hubs.get(vertex);
        VertexHub<V> hub = new VertexHub<>();
        hubs.put(vertex, hub);
        return hub;
    }

    private static class VertexHub<V extends Vertex> {
        private final Map<V, Edge<V>> incoming = new HashMap<>();
        private final Map<V, Edge<V>> outgoing = new HashMap<>();
    }
}
