package Es3;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.shortestpath.*;

import java.util.*;

public class CastelloInfestato {
	
	static Random r = new Random();

    public static void main(String[] args) {
        // Esempio di input
        int n = 6; // Numero di stanze
        List<int[]> corridoi = new ArrayList<>(); // Corridoi tra le stanze
        
        int[] M = new int[n];
        // Array dei mostri: 1 indica un mostro
        for (int i = 1; i < n-1; i++) {
			if (r.nextBoolean()) {M[i] = 1;}
		}
        
        // Corridoi tra le stanze
        for (int i = 0; i < n-1; i++) {
			for (int j = 1; j < n; j++) {
				if (i != j && r.nextBoolean()) {
					int[] new_corr = {i+1,j+1};
					corridoi.add(new_corr);
				}
			}
		}
        
        for (int i : M) {
			System.out.print(i+"; ");
		}
        System.out.println();
        for (int[] i : corridoi) {
			System.out.print(i[0] +"-"+i[1]+"; ");
        }
        System.out.println();
        
        
        int s = 1; // Stanza di partenza
        int d = 6; // Stanza di destinazione

        // Chiamata al metodo per calcolare il minimo numero di corridoi
        GraphPath risultato = minimoCorridoi(n, corridoi, M, s, d);

        // Output del risultato
        if (risultato == null) {
            System.out.println("Non è possibile raggiungere la destinazione senza incontrare mostri.");
        } else {
            System.out.println("Il minimo numero di corridoi da attraversare è: " + risultato.getLength());
            System.out.println(risultato.toString());
        }
    }

    public static GraphPath minimoCorridoi(int n, List<int[]> corridoi, int[] M, int s, int d) {
        // Creazione del grafo
        Graph<Integer, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
        GraphPath<Integer, DefaultEdge> percorso = null;

        // Aggiunta dei vertici
        for (int i = 0; i < n; i++) {
            if (M[i] == 0) { // Aggiungiamo solo stanze senza mostri
                grafo.addVertex(i+1);
            }
        }
        
        // Verifica se i vertici di partenza e destinazione sono presenti
        if (!grafo.containsVertex(s) || !grafo.containsVertex(d)) {
            return percorso; // Non è possibile raggiungere la destinazione
        }

        // Aggiunta degli archi (corridoi)
        for (int[] corridoio : corridoi) {
            int u = corridoio[0];
            int v = corridoio[1];
            if (grafo.containsVertex(u) && grafo.containsVertex(v)) { // Solo se entrambe le stanze sono libere
                grafo.addEdge(u, v);
            }
        }
        
        System.out.println("Grafo ([Vertex], [Edges]): " + grafo.toString());

        // Calcolo del percorso più breve usando DijkstraShortestPath
        DijkstraShortestPath<Integer, DefaultEdge> dijkstra = new DijkstraShortestPath<>(grafo);
        percorso = dijkstra.getPath(s, d);

        if (percorso == null) {
            return percorso; // Non c'è un percorso disponibile
        }

        return percorso;
    }
}
