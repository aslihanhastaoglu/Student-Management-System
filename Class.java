import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Class implements Serializable{
	
	static List<Student> studentList;
	private UUID id;
	private String name;
	private School school;

	public Class(String name, School school) {
		UUID uuid=UUID.randomUUID();
		this.name= name;
		this.id = uuid;
		this.setSchool(school);
	}
	
	public Class() {
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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}

	
	public static void addStudent(Student newStudent){
		studentList.add(newStudent);
    }

	public Class Olustur(School school) {
		Scanner obj = new Scanner(System.in);
	    System.out.println("Sýnýf Adý: ");
	    String ad = obj.nextLine();
		Class sýnýf = new Class(ad,school);
		return sýnýf;
	}

	public String Getir() {
		return  name  + " sýnýfý";
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name ;
	}
	

}
