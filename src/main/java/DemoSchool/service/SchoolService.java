package DemoSchool.service;

import DemoSchool.exception.service.SchoolServiceException;
import DemoSchool.model.Classroom;
import DemoSchool.model.Student;

public interface SchoolService {

	Classroom addClassroom(Classroom classroom) throws SchoolServiceException;

	Student addStudent(Student student, int classId) throws SchoolServiceException;

	Student getStudentById(int studentId) throws SchoolServiceException;

	Student updateStudentById(int studentId, int age) throws SchoolServiceException;

}
