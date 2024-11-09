package TreeMap;

import java.util.Set;
import java.util.TreeMap;

public class AlberoRossoNero implements StringCollection {

	private TreeMap<String, String> albero;

	public AlberoRossoNero() {
		albero = new TreeMap<>();
	}

	@Override
	public void insert(String stringToAdd) {
		albero.put(stringToAdd, "");
	}

	@Override
	public boolean delete(String stringToDelete) {
		return (albero.remove(stringToDelete) != null ? true : false);
	}

	@Override
	public boolean contains(String stringToSearch) {
		return albero.containsKey(stringToSearch);
	}

	@Override
	public String printOrdedString() {
		Set<String> keys = albero.keySet();
		return keys.toString();
	}
}