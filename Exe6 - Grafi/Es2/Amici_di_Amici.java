package Es2;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.HashSet;
import java.util.Set;

public class Amici_di_Amici {

    public static <V> V findPersonWithMostFriends(Graph<V, DefaultEdge> graph) {
        V maxPerson = null;
        int maxFriends = 0;
        
        /**
         * vertexSet(): Returns a set of the vertices contained in this graph.
         * edgesOf(V vertex): Returns a set of all edges touching the specified vertex
         * getEdgeTarget(E e): Returns the target vertex of an edge.
         */

        for (V person : graph.vertexSet()) {
            // Ottieni i vicini a distanza 1 (amici)
            Set<V> friends = new HashSet<>(graph.edgesOf(person).size());
            for (DefaultEdge edge : graph.edgesOf(person)) {
                friends.add(graph.getEdgeTarget(edge).equals(person) ? graph.getEdgeSource(edge) : graph.getEdgeTarget(edge));
            }

            // Ottieni i vicini a distanza 2 (amici di amici)
            Set<V> friendsOfFriends = new HashSet<>();
            for (V friend : friends) {
                for (DefaultEdge edge : graph.edgesOf(friend)) {
                    V neighbor = graph.getEdgeTarget(edge).equals(friend) ? graph.getEdgeSource(edge) : graph.getEdgeTarget(edge);
                    if (!neighbor.equals(person) && !friends.contains(neighbor)) {
                        friendsOfFriends.add(neighbor);
                    }
                }
            }

            // Conta il totale di amici e amici di amici
            int totalFriends = friends.size() + friendsOfFriends.size();

            // Aggiorna se troviamo una persona con pi� amici
            if (totalFriends > maxFriends) {
                maxFriends = totalFriends;
                maxPerson = person;
            }
        }

        System.out.println("La persona con il maggior numero di amici e amici di amici �: " + maxPerson);
        System.out.println("Numero di amici e amici di amici: " + maxFriends);
        return maxPerson;
    }

    public static void main(String[] args) {
        // Creazione del grafo di esempio
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        String[] people = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy"};
        for (String person : people) {
            graph.addVertex(person);
        }

        // Aggiungi gli archi (amicizie)
        // Judy e' l'unica persona che ha 9 amici (connessa a tutti gli altri)
        for (String person : people) {
            if (!person.equals("Judy")) {
                graph.addEdge("Judy", person);
            }
        }

        // Aggiungi alcune amicizie casuali tra le altre persone
        graph.addEdge("Alice", "Bob");
        graph.addEdge("Alice", "Charlie");
        graph.addEdge("Bob", "Diana");
        graph.addEdge("Charlie", "Eve");
        graph.addEdge("Diana", "Frank");
        graph.addEdge("Eve", "Grace");
        graph.addEdge("Frank", "Heidi");
        graph.addEdge("Grace", "Ivan");

        // Trova la persona con piu' amici e amici di amici
        findPersonWithMostFriends(graph);
    }
}
