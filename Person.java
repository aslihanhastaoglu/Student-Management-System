import java.io.Serializable;
import java.util.UUID;

public class Person implements Serializable{

	private UUID id;
	private String name;
	private String surname;
	
	public Person() {
	}

	public Person(String name, String surname) {
		UUID uuid=UUID.randomUUID();
		this.name= name;
		this.id = uuid;
		this.surname = surname;
	}


	public UUID getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}
	
	public String getFullName() {
		return name + " "+ surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String Getir() {
		return "Adým " + this.getFullName() +", ";
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", surname=" + surname;
	}
	

}
