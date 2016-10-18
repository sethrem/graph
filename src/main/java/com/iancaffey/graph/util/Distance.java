package com.iancaffey.graph.util;

import com.iancaffey.graph.Vertex;

/**
 * Distance
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface Distance {
    public default double between(double x1, double y1, double x2, double y2) {
        return between(x1, y1, 0, x2, y2, 0);
    }

    public default double between(Vertex source, Vertex destination) {
        if (source == null || destination == null)
            throw new IllegalArgumentException();
        return between(source.x, source.y, source.z, destination.x, destination.y, destination.z);
    }

    public default double between(Vertex source, double x, double y, double z) {
        if (source == null)
            throw new IllegalArgumentException();
        return between(source.x, source.y, source.z, x, y, z);
    }

    public double between(double x1, double y1, double z1, double x2, double y2, double z2);
}
