package com.iancaffey.graph;

import java.util.Objects;

/**
 * Edge
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Edge<V> {
    public final V source;
    public final V destination;
    public final double weight;

    public Edge(V source, V destination, double weight) {
        if (source == null || destination == null || weight < 0)
            throw new IllegalArgumentException();
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Edge && source.equals(((Edge) o).source) && destination.equals(((Edge) o).destination) && weight == ((Edge) o).weight;
    }

    @Override
    public String toString() {
        return String.format("%s[source=%s, destination=%s, weight=%f]", getClass().getSimpleName(), source, destination, weight);
    }
}
