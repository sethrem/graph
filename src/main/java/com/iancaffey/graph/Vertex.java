package com.iancaffey.graph;

import java.util.Objects;

/**
 * Vertex
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Vertex {
    public final double x;
    public final double y;
    public final double z;

    public Vertex() {
        this(0, 0);
    }

    public Vertex(double x, double y) {
        this(x, y, 0);
    }

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && x == ((Vertex) o).x && y == ((Vertex) o).y && z == ((Vertex) o).z;
    }

    @Override
    public String toString() {
        return String.format("%s[x=%f,y=%f,z=%f]", getClass().getSimpleName(), x, y, z);
    }
}
