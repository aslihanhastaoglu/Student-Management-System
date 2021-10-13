import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class School implements Serializable{
	
	List<Class> classList;
	List<Employee> employeeList;
	private UUID id;
	private String name;
	private String address;
	
	public School() {
		classList = new ArrayList<Class>();
		employeeList = new ArrayList<Employee>();
	}

	public School(String name, String address) {
		UUID uuid = UUID.randomUUID();
		this.name= name;
		this.id = uuid;
		this.address = address;
		classList = new ArrayList<Class>();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Class> getClassList() {
		return classList;
	}
	
	public void addClass(Class newClass){
		classList.add(newClass);
    }
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public void addEmployee(Employee newEmployee){
		employeeList.add(newEmployee);
    }

	public School Olustur() {
		Scanner obj = new Scanner(System.in);
	    System.out.println("Okul Adý: ");
	    String ad = obj.nextLine();
	    System.out.println("Okul Adresi: ");
	    String adres = obj.nextLine();
		School _school = new School(ad,adres);
		return _school;
	}


	public String Getir() {
		return "Okulun Adý " + name + ", adresi " + address + ".";
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", address=" + address + "";
	}
	
	
	

}
