package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.Student;
import in.sp.main.repositories.StudentRepositories;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepositories studentRepository;

	@Override
	public Student createStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}
	
	@Override
	public Optional<Student> getStudentById(int id) {
		
		return studentRepository.findById(id);
	}
	
	@Override
	public Student updateStudent(int id, Student newStudent) {
		
		Student student = studentRepository.findById(id).orElse(null);
		
		if(student != null) {
			return studentRepository.save(newStudent);
		}
		
		return null;
	}
	
	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
