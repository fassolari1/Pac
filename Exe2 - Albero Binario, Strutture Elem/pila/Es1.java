package pila;

import coda.CodaCollegata;

public class Es1 {

	public static void main(String[] args) {
		
		Pila pila = new Pila();
		CodaCollegata coda = new CodaCollegata();
		
		pila.push("Elemento 1");
	    pila.push("Elemento 2");
	    pila.push("Elemento 3");
	    pila.push("Elemento 4");
	    
	    System.out.println("pila:\n" + pila.stamp());
	    
	    coda.enqueue(pila.pop());
	    coda.enqueue(pila.pop());
	    coda.enqueue(pila.pop());
	    coda.enqueue(pila.pop());
	    
	    pila.push(coda.dequeue());
	    pila.push(coda.dequeue());
	    pila.push(coda.dequeue());
	    pila.push(coda.dequeue());
	    
	    System.out.println("pila:\n" + pila.stamp());

	    
	}

}
