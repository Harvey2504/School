package DemoSchool.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoSchool.exception.SchoolCustomException;
import DemoSchool.exception.service.SchoolServiceException;
import DemoSchool.model.Classroom;
import DemoSchool.model.Student;
import DemoSchool.repository.ClassroomRepository;
import DemoSchool.repository.StudentRepository;
import DemoSchool.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassroomRepository classroomRepository;

	@Override
	public Classroom addClassroom(Classroom classroom) throws SchoolServiceException {
		// TODO Auto-generated method stub
		try {
			Classroom newClassroom = classroomRepository.save(classroom);
			return newClassroom;
		} catch (Exception e) {
			throw new SchoolServiceException(e);
		}
	}

	@Override
	public Student addStudent(Student student, int classId) throws SchoolServiceException {
		// TODO Auto-generated method stub
		try {
			Classroom classroom = classroomRepository.findById(classId).get();
			classroom.setNoOfStudents(classroom.getNoOfStudents() + 1);
			student.setClassroom(classroom);
			Student newStudent = studentRepository.save(student);
			return newStudent;
		} catch (Exception e) {
			throw new SchoolServiceException(e);
		}
	}

	@Override
	public Student getStudentById(int studentId) throws SchoolServiceException {
		// TODO Auto-generated method stub
		try {
			Student temp = studentRepository.findById(studentId).get();
			return temp;
		} catch (Exception e) {
			throw new SchoolServiceException("StudentId Not Found");
		}
	}

	@Override
	public Student updateStudentById(int studentId, int age) throws SchoolServiceException {
		// TODO Auto-generated method stub

		try {
			Student temp = studentRepository.findById(studentId).get();
			temp.setAge(age);
			Student newStudent = studentRepository.save(temp);
			return newStudent;

		} catch (Exception e) {
			throw new SchoolServiceException("StudentId Not Found");
		}

	}

}
