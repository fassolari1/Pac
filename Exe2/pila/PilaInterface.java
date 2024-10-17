package pila;

public interface PilaInterface<E>{
	
	public E peek();
	
	public boolean empty();
	
	public E pop();
	
	public int push(E o);
	
	public int search(E o);

}
