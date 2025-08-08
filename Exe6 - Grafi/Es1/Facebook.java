package Es1;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.SimpleGraph;

public class Facebook {
	
	public static void main(String[] args) {
		Graph<String, DefaultEdge> grafoAmici =
	            new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

		// creo i vertici
		grafoAmici.addVertex("Aldo");
		grafoAmici.addVertex("Giovanni");
		grafoAmici.addVertex("Giacomo");
		grafoAmici.addVertex("Fabio");
		
		
		// connetto i vertici con gli archi 
		grafoAmici.addEdge("Aldo", "Giovanni"); 
		grafoAmici.addEdge("Aldo", "Giacomo");
		grafoAmici.addEdge("Giovanni", "Giacomo");
		grafoAmici.addEdge("Giovanni", "Aldo");
		grafoAmici.addEdge("Giacomo", "Giovanni");
		grafoAmici.addEdge("Giacomo", "Aldo");

		grafoAmici.addEdge("Fabio", "Aldo");

        // Stampa il grafo
		stampaAmiciDiretti(grafoAmici);
	}
	
	private static void stampaAmiciDiretti(Graph<String, DefaultEdge> grafo) {
		Set<String> vertici = grafo.vertexSet(); 
		for (String s : vertici) {
			System.out.print(s.toString() + ": ");
			List<String> succ = Graphs.successorListOf(grafo, s);
			System.out.println(succ.toString());
        }
    }
	
	
			
	
}
