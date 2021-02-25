package DemoSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DemoSchool.exception.service.SchoolServiceException;
import DemoSchool.model.Classroom;
import DemoSchool.model.Student;
import DemoSchool.service.serviceImpl.SchoolServiceImpl;

@RestController
@RequestMapping(path = "/school")
public class SchoolController {
	static String msg = "";

	@Autowired
	public SchoolServiceImpl service;

	@PostMapping("/add/classroom")
	public ResponseEntity<?> addClassroom(@RequestBody Classroom classroom) {
		try {
			return new ResponseEntity<>(service.addClassroom(classroom), HttpStatus.CREATED);
		} catch (SchoolServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add/student/{classId}")
	public ResponseEntity<?> addStudent(@RequestBody Student student, @PathVariable Integer classId) {
		try {
			return new ResponseEntity<>(service.addStudent(student, classId), HttpStatus.CREATED);
		} catch (SchoolServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/{studentId}")
	public ResponseEntity<?> getStudentDetails(@PathVariable Integer studentId) {
		try {
			return new ResponseEntity<>(service.getStudentById(studentId), HttpStatus.OK);
		} catch (SchoolServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update/{studentId}")
	public ResponseEntity<?> updateStudentAge(@RequestBody Integer age, @PathVariable Integer studentId) {
		try {
			return new ResponseEntity<>(service.updateStudentById(studentId, age), HttpStatus.OK);

		} catch (SchoolServiceException e) {
			msg = e.getLocalizedMessage();
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

}
