package TreeMap;

public class Tester {

	public static void main(String[] args) {
		AlberoRossoNero albero = new AlberoRossoNero();
		albero.insert("C");
		albero.insert("A");
		albero.insert("E");
		albero.insert("B");
		albero.insert("Balena");
		albero.insert("D");
		albero.insert("Prova");
		albero.insert("Albero");

		System.out.println(albero.printOrdedString());

		System.out.println("Contains A:" + albero.contains("A"));

		System.out.println("Contains Z:" + albero.contains("Z"));

		System.out.println("Contains i:" + albero.contains("i"));

		System.out.println("Delete A:" + (albero.delete("A") == true ? "success" : "fail"));
		System.out.println("Delete i:" + (albero.delete("i") == true ? "success" : "fail"));
		System.out.println("Delete Balena:" + (albero.delete("Balena") == true ? "success" : "fail"));

		System.out.println(albero.printOrdedString());

	}

}
