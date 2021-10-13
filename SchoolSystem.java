import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolSystem implements Serializable{
	
	List<School> schoolList;

	public SchoolSystem() {
		// TODO Auto-generated constructor stub
		schoolList = new ArrayList<School>();
	}
	
	public List<School> getSchoolList() {
		return schoolList;
	}

	public void addSchool(School newSchool){
		schoolList.add(newSchool);
    }
	
}
