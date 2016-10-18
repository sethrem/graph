# graph [![Build Status](https://travis-ci.org/iitc/graph.svg?branch=master)](https://travis-ci.org/iitc/graph)
Graph traversal and optimization framework. 

## Examples

### Vertex Addition
```java
Graph<Vertex> graph = Graphs.newEmptyGraph();
Vertex vertex = new Vertex();
graph.add(vertex);
```

### Vertex Removal
```java
Graph<Vertex> graph = Graphs.newEmptyGraph();
Vertex vertex = new Vertex();
graph.add(vertex);
graph.remove(vertex);
```

### Edge Creation
```java
Graph<Vertex> graph = Graphs.newEmptyGraph();
Vertex one = new Vertex(123, 456, 0);
Vertex two = new Vertex(321, 654, 0);
double weight = 14.5;
graph.add(one);
graph.add(two);
Edge<Vertex> edge = graph.connect(one, two, weight);
```

### Edge Removal
```java
Graph<Vertex> graph = Graphs.newEmptyGraph();
Vertex one = new Vertex(123, 456, 0);
Vertex two = new Vertex(321, 654, 0);
double weight = 14.5;
graph.add(one);
graph.add(two);
Edge<Vertex> edge = graph.connect(one, two, weight);
graph.disconnect(one, two); 
// or
graph.disconnect(edge);
```

### Edge Creation (bidirectional)
```java
Graph<Vertex> graph = Graphs.newEmptyGraph();
Vertex one = new Vertex(123, 456, 0);
Vertex two = new Vertex(321, 654, 0);
double weight = 14.5;
graph.add(one);
graph.add(two);
graph.connectBidirectional(one, two, weight);
```

### Edge Removal (bidirectional)
```java
Graph<Vertex> graph = Graphs.newEmptyGraph();
Vertex one = new Vertex(123, 456, 0);
Vertex two = new Vertex(321, 654, 0);
double weight = 14.5;
graph.add(one);
graph.add(two);
graph.connectBidirectional(one, two, weight);
graph.disconnectBidirectional(one, two);
```
