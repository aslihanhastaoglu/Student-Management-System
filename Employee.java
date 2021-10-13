public class Employee extends Person{
	
	private String sgkId;
	private School school;
	
	public Employee() {
	}
	
	public Employee(String name, String surname, String sgkId, School school) {
		super(name, surname);
		this.sgkId = sgkId;
		this.school = school;
	}
	public String getSgkId() {
		return sgkId;
	}
	public void setSgkId(String sgkId) {
		this.sgkId = sgkId;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return super.toString() +"sgkId=" + sgkId + ", school=" + school;
	}
	
	
}
