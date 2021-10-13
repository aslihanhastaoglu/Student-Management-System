import java.util.List;
import java.util.Scanner;

public class Student extends Person{
	
	private Class _class;
	private int number;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, String surname) {
		super(name, surname);
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String surname, Class _class, int number) {
		super(name, surname);
		this._class = _class;
		this.number = number;
	}

	public Class get_class() {
		return _class;
	}

	public void set_class(Class _class) {
		this._class = _class;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	public Student Olustur(Class selectedClass) {
		Scanner obj = new Scanner(System.in);
	    System.out.println("��rencini Ad�: ");
	    String ad = obj.nextLine();
	    System.out.println("��rencini Soyad�: ");
	    String soyad = obj.nextLine();
	    System.out.println("��rencini Numaras�: ");
	    int number = obj.nextInt();
		Student student = new Student(ad,soyad, selectedClass, number);
		return student;
	}

	public String Getir() {
		return super.Getir() + _class.getSchool().getName() + "'unda ��renciyim. " + _class.getName() + " s�n�f�nda ��renciyim. Numaram " + getNumber();
	}

	@Override
	public String toString() {
		return super.toString() + ", number=" + number + "class=" + _class.getId();
	}
	
	
	
}
