package soluzione2024;

import java.util.Iterator;
import java.util.TreeSet;


public class AlberoStringhe extends TreeSet<String> implements InsiemeStringhe {

	private static final long serialVersionUID = -7483013507545010014L;

	// Metodo di inserimento
	@Override
	public void insert(String s) {
		super.add(s);
	}

	// Metodo di rimozione
	@Override
	public void delete(String s) {
		super.remove(s);
	}

	// Controllo presenza stringhe
	@Override
	public boolean contains(String s) {
		return super.contains(s);
	}

	// Concatenazione del contenuto
	@Override
	public String concat() {
		Iterator<String> iter = super.iterator();
		StringBuffer buf = new StringBuffer();
		
		while(iter.hasNext()) {
			buf.append(iter.next());
		}
		return buf.toString();
	}
	
	// Metodo di stampa per il debug (simile a concat)
	@Override
	public String toString() {
		Iterator<String> iter = super.iterator();
		StringBuffer buf = new StringBuffer();
		
		while(iter.hasNext()) {
			buf.append(iter.next());
			if (iter.hasNext())
				buf.append(", ");
		}
		return buf.toString();
	}

}