import java.util.Scanner;

public class Officer extends Employee{
	
	public Officer() {
		// TODO Auto-generated constructor stub
	}

	public Officer(String name, String surname, String sgkId, School school) {
		super(name, surname, sgkId, school);
		// TODO Auto-generated constructor stub
	}
	
	
	public Officer Olustur(School school) {
		Scanner obj = new Scanner(System.in);
	    System.out.println("Adý: ");
	    String ad = obj.nextLine();
	    System.out.println("Soyadý: ");
	    String soyad = obj.nextLine();
	    System.out.println("SGK Id: ");
	    String sgkId = obj.nextLine();
		Officer _officer = new Officer(ad, soyad, sgkId, school);
		return _officer;
	}

	public String Getir() {
		return super.Getir() + getSchool().getName() + " 'unda memurum. , SGK Id" + getSgkId();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
