package TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class StringTree implements Gestore_TreeSet{
	
	private TreeSet<String> t;
	
	public StringTree() {
		this.t = new TreeSet<String>();
	}
	@Override
	public void insertString(String s) {
		t.add(s);
	}

	@Override
	public void deleteString(String s) {
		t.remove(s);	
	}

	@Override
	public boolean checkString(String s) {
		return t.contains(s);		
	}

	@Override
	public String concatString() {
		Iterator<String> i = t.iterator();
		String temp = "CONCATENATED STRING: ";
		while(i.hasNext()) {
			temp = temp + i.next() + ";";
		}
		return temp;
	}
	public void print(){
		System.out.println(t.toString());
	}
	@Override
	public void insertString(Object s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteString(Object s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean checkString(Object s) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object concat() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
