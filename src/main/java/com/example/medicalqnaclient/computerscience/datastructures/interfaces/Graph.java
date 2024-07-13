package com.example.medicalqnaclient.computerscience.datastructures.interfaces;

public interface Graph<V, E> {
    void addVertex(V vertex);
    void addEdge(V source, V destination, E weight);
    void removeVertex(V vertex);
    void removeEdge(V source, V destination);
    boolean containsVertex(V vertex);
    boolean containsEdge(V source, V destination);
    void traverse();
}
