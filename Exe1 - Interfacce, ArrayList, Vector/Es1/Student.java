package Es1;

//Only student's status information
public class Student extends Person implements Comparable<Student>{
	
	String university;
	String birthday;
	int matricola;

	public Student(String name, String surname, String university, String birthday, int matricola) {
		this.name = name;
		this.surname = surname;
		this.university = university;
		this.birthday = birthday;
		this.matricola = matricola;
	}

	public boolean equals(Object o) {
		// se è lo stesso oggetto --> True
		if (this == o)
			return true;
		// se non è un oggetto Students --> False
		if (!(o instanceof Student))
			return false;
		
		Student other = (Student) o;
		return name.equals(other.name) && 
				surname.equals(other.surname) && 
				university.equals(other.university)
				&& birthday.equals(other.birthday) && 
				matricola == other.matricola;
	}

	@Override
	public int compareTo(Student o) {
		// primo controllo sulla matricola
		int diff = this.matricola - o.matricola;
		if (diff != 0)	// se non ci entra vuol dire che è = la matricola
			return diff;
		// potrebbe venire da un altro ateneo
		// secondo controllo sull'anagrafica
		if (this.surname.compareToIgnoreCase(o.surname) > 0)
			return +1;
		else if (this.surname.compareToIgnoreCase(o.surname) < 0)
			return -1;
		else if (this.surname.compareToIgnoreCase(o.surname) == 0 &&
				this.name.compareToIgnoreCase(o.name) == 0 &&
				this.birthday.compareTo(o.birthday) == 0)
			return 0;
		else
			return 1;
	}

	public String toString() {
		return "nome: " + this.name + ", cognome: " + this.surname + ", università : " + this.university + ", birthday: "
				+ this.birthday;
	}

}
