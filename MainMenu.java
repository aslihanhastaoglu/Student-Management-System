import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainMenu {

	static School _school;
	static Class _class;
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println("Sivas Ýli Okul Sistemi");
		baseMenu();
	}
	
	public static  void baseMenu() {
		System.out.println("Okul Menü");
		System.out.println("1- Okullar Listesi");
		System.out.println("2- Okul Tanýmlama");
		System.out.println("3- Okul Ziyareti");
		System.out.println("4- Cikis");
		Scanner scan = new Scanner(System.in);
		System.out.print("Seçiminiz (1/2/3)  ?  :");
		int val = scan.nextInt();
		switch (val) {
		case 1: {
			getSchools();
			baseMenu();
			break;
		}
		case 2: {
			ArrayList<School> schools = fillSchool();
			School school= new School();
			school = school.Olustur();
			schools.add(school);
			writeSchools(schools);
			baseMenu();
			break;
				}
		case 3: {
			Scanner scan1 = new Scanner(System.in);
			System.out.print("Ziyaret etmek istediðiniz okulun sýra numarasýný giriniz(1/2/3..) :");
			int number = scan1.nextInt();
			visitSchools(number);
			classMenu();
			break;
		}
		case 4: {
			System.out.println("Program bitiyor.");
			System.out.println("Programlayan: Gamze Selvili 190102010 yazarak bitiriniz.");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + val);
		}
	}
	
	public static void classMenu() {
		System.out.println("Sýnýf Menü");
		System.out.println("1- Okulun Sýnýflarý");
		System.out.println("2- Okula Çalýþan Tanýmlama");
		System.out.println("3- Sýnýf Ziyareti");
		System.out.println("4- Sýnýf Tanýmlama");
		System.out.println("5- Ana Menu");
		System.out.println("6- Cikis");
		Scanner scan = new Scanner(System.in);
		System.out.print("Seçiminiz (1/2/3)  ?  :");
		int val = scan.nextInt();
		switch (val) {
		case 1: {
			getClasses();
			classMenu();
			break;
		}
		case 2: {
			createEmployee();
		}
		case 3: {
			Scanner scan1 = new Scanner(System.in);
			System.out.print("Ziyaret etmek istediðiniz sýnýfýn sýra numarasýný giriniz(1/2/3..) :");
			int number = scan1.nextInt();
			visitClass(number);
			classSubMenu();
			break;
		}
		case 4: {
			ArrayList<Class> classes = fillClass();
			Class sýnýf= new Class();
			sýnýf = sýnýf.Olustur(_school);
			classes.add(sýnýf);
			writeClasses(classes);
			classMenu();
			break;
		}
		case 5: {
			baseMenu();
			break;
		}
		case 6: {
			System.out.println("Program bitiyor.");
			System.out.println("Programlayan: Gamze Selvili 190102010 yazarak bitiriniz.");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + val);
		}
	}
	
	public static void classSubMenu() {
		System.out.println("Aktif Sýnýf Alt Menü");
		System.out.println("1- Sýnýfýn Öðrencileri");
		System.out.println("2- Sýnýfa Öðretmen Tanýmlama");
		System.out.println("3- Sýnýfa Öðrenci Tanýmlama");
		System.out.println("4- Üst Menu");
		System.out.println("5- Cikis");
		Scanner scan = new Scanner(System.in);
		System.out.print("Seçiminiz (1/2/3/4/5)  ?  :");
		int val = scan.nextInt();
		switch (val) {
		case 1: {
			getStudents();
			classSubMenu();
			break;
		}
		case 2: {
			ArrayList<Teacher> teachers = fillTeacher();
			if(teachers.size() != 0) {
				Iterator<Teacher> i = teachers.iterator();
				while (i.hasNext()) {
					Teacher s = i.next();
					if(s.get_class().getId().equals(_class.getId())) {
						System.out.println("Sýnýfa atanmýþ öðretmeni deðiþtir!");
						i.remove();
					}
				}
			}
			Teacher teacher= new Teacher();
			teacher = teacher.Olustur(_school ,_class);
			teachers.add(teacher);
			writeTeacher(teachers);
			getTeachers();
			classSubMenu();
			break;
		}
		case 3: {
			ArrayList<Student> students = fillStudent();
			Student student= new Student();
			student = student.Olustur(_class);
			students.add(student);
			writeStudents(students);
			classSubMenu();
			break;
		}
		case 4: {
			classMenu();
			break;
		}
		case 5: {
			System.out.println("Program bitiyor.");
			System.out.println("Programlayan: Gamze Selvili 190102010 yazarak bitiriniz.");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + val);
		}
	}
	
	//region Okul Menüsü
	public static void getSchools() {
		ArrayList<School> schools = fillSchool();
		
        System.out.println("Okullar Listesi");
        
        int i = 0;
        for (School school : schools) {
        	i++;
	        System.out.println(i+" - "+school.Getir());
		}
	}
	
	public static ArrayList<School> fillSchool() {
		ArrayList<School> schools = new ArrayList<School>();
		File file = new File("school.txt");
        if (file.length() == 0) {
        	 System.out.println("Okul Bulunamadý! Yeni okul oluþturunuz!");
        	 School school= new School();
			 school = school.Olustur();
			 schools.add(school);
			 writeSchools(schools);
        }
        else {
        
        	try{
                FileInputStream readData = new FileInputStream("school.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                schools = (ArrayList<School>) readStream.readObject();
                readStream.close();
                //System.out.println(schools.toString());
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return schools;
	}
	
	
	public static void visitSchools(int id) {
		ArrayList<School> schools = fillSchool();
        int i = 0;
        for (School school : schools) {
        	i++;
        	if(i == id) {
        		_school = school;
        		System.out.println("Seçili Okul "+school.Getir());
        		getManager();
        		getOfficer();
        	}
		}
	}
	
	public static void writeSchools(ArrayList<School> schools) {
		try{
            FileOutputStream writeData = new FileOutputStream("school.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(schools);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Sýnýf Menüsü
	public static void getClasses() {
		ArrayList<Class> classes = fillClass();
        System.out.println("Sýnýflar Listesi");        
        int i = 0;
        for (Class sýnýf : classes) {
        	if(sýnýf.getSchool().getId().equals(_school.getId())) {
        		i++;
        		System.out.println(i+" - "+ sýnýf.Getir());
	        }   
		}
        if(i == 0)
        	System.out.println("Okula ait sýnýf bulunamadý!");
	}
	
	public static ArrayList<Class> fillClass() {
		ArrayList<Class> classes = new ArrayList<Class>();
		File file = new File("class.txt");
        if (file.length() != 0) {
        	try{
                FileInputStream readData = new FileInputStream("class.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                classes = (ArrayList<Class>) readStream.readObject();
                readStream.close();
                
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(file.length() == 0 || classes.size() == 0){
        	System.out.println("Sýnýf Bulunamadý! Yeni sýnýf oluþturunuz!");
       	     /*Class sýnýf= new Class();
       	 	 sýnýf = sýnýf.Olustur(_school);
			 classes.add(sýnýf);
			 writeClasses(classes);*/
        }
        return classes;
	}
	
	
	public static void visitClass(int id) {
		ArrayList<Class> classes = fillClass();
        int i = 0;
        for (Class sýnýf : classes) {
        	if(sýnýf.getSchool().getId().equals(_school.getId())) {
        		i++;
            	if(i == id) {
            		_class = sýnýf;
            		System.out.println("Seçili Sýnýf "+_class.Getir());
            		getTeachers();
            		getStudents();
            	}
	        }
		}
	}
	
	public static void writeClasses(ArrayList<Class> classes) {
		try{
            FileOutputStream writeData = new FileOutputStream("class.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(classes);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Sýnýf Detay Menüsü
	public static void getStudents() {
		ArrayList<Student> students = fillStudent();
        System.out.println("Öðrenciler Listesi");
        
        int i = 0;
        for (Student student : students) {
        	if(student.get_class().getId().equals(_class.getId())) {
        		i++;
    	        System.out.println(i+" - "+ student.Getir());
	        }
		}
        if(i == 0)
        	System.out.println("Sýnýfa ait öðrenci bulunamadý!");
	}
	
	public static ArrayList<Student> fillStudent() {
		ArrayList<Student> students = new ArrayList<Student>();
		File file = new File("student.txt");
        if (file.length() != 0) {
        	try{
                FileInputStream readData = new FileInputStream("student.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                students = (ArrayList<Student>) readStream.readObject();
                readStream.close();
                
                //System.out.println(getStudents.toString());
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
        	System.out.println("Öðrenci Bulunamadý! Yeni Öðrenci oluþturunuz!");
       	 	/*Student student= new Student();
       	 	 student = student.Olustur(_class);
			 students.add(student);
			 writeStudents(students);*/
        	
        }
        return students;
	}
	
	
	public static void visitStudent(int id) {
		ArrayList<Student> students = fillStudent();
        int i = 0;
        for (Student student : students) {
        	if(student.get_class().getId().equals(_class.getId())) {
        		i++;
            	if(i == id) {
            		System.out.println(student.Getir());
            	}
	        }
		}
	}
	
	public static void writeStudents(ArrayList<Student> students) {
		try{
            FileOutputStream writeData = new FileOutputStream("student.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(students);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Öðretmen
	public static void getTeachers() {
		ArrayList<Teacher> teachers = fillTeacher();
        System.out.println("Sýnýfýn Öðretmeni");
        
        int i = 0;
        for (Teacher teacher : teachers) {
        	if(teacher.get_class().getId().equals(_class.getId())) {
        		i++;
    	        System.out.println(i+" - "+ teacher.Getir());
	        }
		}
        if(i == 0)
        	System.out.println("Sýnýfa ait öðretmen bulunamadý!");
	}
	
	public static ArrayList<Teacher> fillTeacher() {
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		File file = new File("teacher.txt");
        if (file.length() == 0) {
        	 System.out.println("Öðretmen Bulunamadý! Yeni Öðretmen oluþturunuz!");
        }
        else {
        	try{
                FileInputStream readData = new FileInputStream("teacher.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                teachers = (ArrayList<Teacher>) readStream.readObject();
                readStream.close();
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return teachers;
	}
	
	public static void writeTeacher(ArrayList<Teacher> teachers) {
		try{
            FileOutputStream writeData = new FileOutputStream("teacher.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(teachers);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void createEmployee() {
		System.out.println("1- Müdür");
		System.out.println("2- Memur");
		Scanner scan = new Scanner(System.in);
		System.out.print("Seçiminiz (1/2)  ?  :");
		int val = scan.nextInt();
		switch (val) {
		case 1: {
			ArrayList<Manager> managers = fillManager();
			if(managers.size() != 0) {
				Iterator<Manager> i = managers.iterator();
				while (i.hasNext()) {
					Manager s = i.next();
					if(s.getSchool().getId().equals(_school.getId())) {
						System.out.println("Okula atanmýþ müdürü deðiþtir!");
						i.remove();
					}
				}
			}
			Manager manager= new Manager();
			manager = manager.Olustur(_school);
			managers.add(manager);
			writeManager(managers);
			classMenu();
			break;
		}
		case 2: {
			ArrayList<Officer> officers = fillOfficer();
			Officer officer= new Officer();
			officer = officer.Olustur(_school);
			officers.add(officer);
			writeOfficer(officers);
			classMenu();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + val);
		}
	}
	//Müdür
	public static void getManager() {
		ArrayList<Manager> mannagers = fillManager();
        int i = 0;
        for (Manager manager : mannagers) {
        	if(manager.getSchool().getId().equals(_school.getId())) {
        		i++;
    	        System.out.println(i+" - "+ manager.Getir());
	        }
		}
        if(i == 0)
        	System.out.println("Okula ait müdür bulunamadý!");
	}
	
	public static ArrayList<Manager> fillManager() {
		ArrayList<Manager> managers = new ArrayList<Manager>();
		File file = new File("manager.txt");
        if (file.length() == 0) {
        	 System.out.println("Müdür Bulunamadý! Okula Müdür oluþturunuz!");
        }
        else {
        	try{
                FileInputStream readData = new FileInputStream("manager.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                managers = (ArrayList<Manager>) readStream.readObject();
                readStream.close();
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return managers;
	}
	
	public static void writeManager(ArrayList<Manager> managers) {
		try{
            FileOutputStream writeData = new FileOutputStream("manager.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(managers);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Memur
	public static void getOfficer() {
		ArrayList<Officer> officers = fillOfficer();
        int i = 0;
        for (Officer officer : officers) {
        	if(officer.getSchool().getId().equals(_school.getId())) {
        		i++;
    	        System.out.println(i+" - "+ officer.Getir());
	        }
		}
        if(i == 0)
        	System.out.println("Okula ait memur bulunamadý!");
	}
	
	public static ArrayList<Officer> fillOfficer() {
		ArrayList<Officer> officers = new ArrayList<Officer>();
		File file = new File("officer.txt");
        if (file.length() == 0) {
        	 System.out.println("Memur Bulunamadý! Okula Memur oluþturunuz!");
        }
        else {
        	try{
                FileInputStream readData = new FileInputStream("officer.txt");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                officers = (ArrayList<Officer>) readStream.readObject();
                readStream.close();
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return officers;
	}
	
	public static void writeOfficer(ArrayList<Officer> officers) {
		try{
            FileOutputStream writeData = new FileOutputStream("officer.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(officers);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
	}

}
