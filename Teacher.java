import java.util.Scanner;

public class Teacher extends Employee{
	
	private Class _class;
	
	public Teacher() {
	}

	public Teacher(String name,String surname, String sgkId, School school, Class _class) {
		super(name,surname, sgkId, school);
		this.set_class(_class);
	}

	public Class get_class() {
		return _class;
	}

	public void set_class(Class _class) {
		this._class = _class;
	}
	
	public Teacher Olustur(School _school, Class selectedClass) {
		Scanner obj = new Scanner(System.in);
	    System.out.println("Öðretmenin Adý: ");
	    String ad = obj.nextLine();
	    System.out.println("Öðretmenin Soyadý: ");
	    String soyad = obj.nextLine();
	    System.out.println("SGK Id ");
	    String sgkId = obj.nextLine();
		Teacher teacher = new Teacher(ad,soyad,sgkId, _school, selectedClass);
		return teacher;
	}

	public String Getir() {
		return super.Getir() + getSchool().getName() + " 'unda öðretmenim. , SGK Id" + getSgkId() + " " + _class.getName() + " sýnýfýnda öðretmenim.";
	}

	@Override
	public String toString() {
		return super.toString() + ",_class=" + _class.getId();
	}

}
