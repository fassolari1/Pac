package Es1;

public class main {

	public static void main(String[] args) {
		Student a = new Student("David", "Parenzo", "unibg", "01-02-2000", 1003009);
		Student m = new Student("Massimiliano", "Minnocci", "Rebibbia", "08-07-2006", 1003050);
		Student b = new Student("giuseppe", "cruciani", "unibg", "01-02-2000", 1003000);
		Student c = new Student("giuseppe", "cruciani", "unibg", "01-02-2000", 1003000);
		Student d = new Student("giuseppe", "cruciani", "unibg", "02-06-2001", 1003000);
		/*
		 * System.out.println(a.toString());
		 * System.out.println(m.toString());
		 * System.out.println(b.toString());
		 * System.out.println(c.toString());
		 * System.out.println(d.toString());
		 */
		
		System.out.println(a.equals(m)); //F
		System.out.println(b.equals(c)); //T
		System.out.println(b.equals(d)); //F 
		System.out.println(a.compareTo(m)); //-
		System.out.println(b.compareTo(c)); //0
		System.out.println(b.compareTo(d)); //F 
	}
}
