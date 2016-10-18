import com.iancaffey.graph.Graph;
import com.iancaffey.graph.Graphs;
import com.iancaffey.graph.Vertex;

/**
 * a
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class a {
    public static void main(String[] args) {
        Graph<Vertex> graph = Graphs.newEmptyGraph();
        Vertex one = new Vertex(123, 456, 0);
        Vertex two = new Vertex(321, 654, 0);
        graph.add(one);
        graph.add(two);
        graph.connectBidirectional(one, two, 14.5);
        System.out.println("Vertices: " + graph.vertices());
        System.out.println("One incoming: " + graph.incomingEdges(one));
        System.out.println("Two incoming: " + graph.incomingEdges(two));
        System.out.println("One outgoing: " + graph.outgoingEdges(one));
        System.out.println("Two outgoing: " + graph.outgoingEdges(two));
    }
}
