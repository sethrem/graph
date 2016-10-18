package com.iancaffey.graph.util;

/**
 * StandardDistance
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum StandardDistance implements Distance {
    EUCLIDEAN {
        @Override
        public double between(double x1, double y1, double z1, double x2, double y2, double z2) {
            return Math.sqrt(SQUARED.between(x1, y1, z1, x2, y2, z2));
        }
    },
    MANHATTAN {
        @Override
        public double between(double x1, double y1, double z1, double x2, double y2, double z2) {
            return Math.abs(x2 - x1) + Math.abs(y2 - y1) + Math.abs(z2 - z1);
        }
    },
    SQUARED {
        @Override
        public double between(double x1, double y1, double z1, double x2, double y2, double z2) {
            return Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2);
        }
    }
}
