package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import in.sp.main.entities.Student;

public interface StudentService {
	
	public Student createStudent(Student student);
	public List<Student> getAllStudent();
	public Optional<Student> getStudentById(int id);
	public Student updateStudent(int id, Student student);
	public void deleteStudent(int id);	

}
