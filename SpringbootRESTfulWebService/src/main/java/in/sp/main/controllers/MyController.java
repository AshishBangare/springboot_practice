package in.sp.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entities.Student;
import in.sp.main.services.StudentService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/user")
	public Student addStudentDetails(@RequestBody Student student) {
		
		return studentService.createStudent(student);
	}
	
	@GetMapping("/user")
	public List<Student> getAllUsers(){
		
		 return studentService.getAllStudent();

	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		
		 Student student = studentService.getStudentById(id).orElse(null);
		 
		if(student !=null) {
			return ResponseEntity.ok().body(student);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
	
		Student updatedStudent = studentService.updateStudent(id, student);
		
		if(updatedStudent != null) {
			return ResponseEntity.ok(updatedStudent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		@DeleteMapping("/user/{id}")
		public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
			
			studentService.deleteStudent(id);
			return ResponseEntity.noContent().build();
			
		
	}
}
