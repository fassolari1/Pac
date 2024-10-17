package pila;

import coda.CodaCollegata;

public class TestPila {

	public static void main(String[] args) {
		
		Pila pila = new Pila();
		CodaCollegata coda = new CodaCollegata();
		
		// Verifica se la pila è vuota
        System.out.println("La pila è vuota? " + pila.empty());
        
        // Aggiunta di elementi alla pila (push)
        System.out.println("inserisco");
        
        pila.push("Elemento 1");
        pila.push("Elemento 2");
        pila.push("Elemento 3");
        System.out.println("La pila è vuota? " + pila.empty());
        
        // Verifica il top della pila (peek)
        System.out.println("Elemento in cima alla pila (peek): " + pila.peek());
        
        // Ricerca di un elemento nella pila
        System.out.println("Posizione di 'Elemento 2' nella pila: " + pila.search("Elemento 2"));
        System.out.println("Posizione di 'Elemento 4' nella pila: " + pila.search("Elemento 4")); // elemento non presente
        
        // Rimozione di elementi dalla pila (pop)
        System.out.println("Rimosso dalla pila: " + pila.pop());
        System.out.println("Rimosso dalla pila: " + pila.pop());
        
        // Verifica il top della pila dopo i pop
        System.out.println("Elemento in cima alla pila (peek): " + pila.peek());
        
        // Verifica se la pila è vuota dopo aver rimosso gli elementi
        System.out.println("La pila è vuota? " + pila.empty());
		
	}

}
