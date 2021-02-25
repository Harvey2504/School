package DemoSchool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classID;
	
	private String className;
	private int noOfStudents;

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classroom(int classID, String className, int noOfStudents) {
		super();
		this.classID = classID;
		this.className = className;
		this.noOfStudents = noOfStudents;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

}
