import java.util.Scanner;

public class Manager extends Employee{
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, String surname, String sgkId, School school) {
		super(name, surname, sgkId, school);
		// TODO Auto-generated constructor stub
	}
	
	public Manager Olustur(School school) {
		Scanner obj = new Scanner(System.in);
	    System.out.println("Ad�: ");
	    String ad = obj.nextLine();
	    System.out.println("Soyad�: ");
	    String soyad = obj.nextLine();
	    System.out.println("SGK Id: ");
	    String sgkId = obj.nextLine();
	    Manager _manager = new Manager(ad, soyad, sgkId, school);
		return _manager;
	}
	
	public String Getir() {
		return super.Getir() + getSchool().getName() + " 'unda m�d�r�m. , SGK Id" + getSgkId();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}
