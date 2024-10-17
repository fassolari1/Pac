package pila;

class Record<E>{
	E element;
	Record next;
	int p;
	
	Record(){
		this.element = null;
		this.next = null;
	}
	
	Record(E o, int p){
		this.element = o;
		this.next = null;
		this.p=p;
	}
}

public class Pila<E> implements PilaInterface{
	
	public Record top;
	int i;
	
	public Pila() {
		top = null;
		i=0;
	}

	@Override
	public Object peek() {
		return top.element;
	}

	@Override
	public boolean empty() {
		return top == null;
	}

	@Override
	public Object pop() {
		i--;
		Record o = top;
		top = top.next;
		return o.element;
	}

	@Override
	public int push(Object o) {
		Record r = new Record(o,i++);
		r.next = top;
		top = r;
		return (r.p);
	}

	@Override
	public int search(Object o) {
		Record s = top;
		while(s!=null) {
			if(s.element == o) return s.p;
			s = s.next;
		}
		return -1;
	}
	
	
	public String stamp() {
		String s = "";
		Record i = top;
		while(i!=null) {
			s += (String)i.element + "\n";
			i=i.next;
		}
		return s;
	}
	
	
}
