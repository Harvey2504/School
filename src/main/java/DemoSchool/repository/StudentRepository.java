package DemoSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DemoSchool.model.Student;
//try without it
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
