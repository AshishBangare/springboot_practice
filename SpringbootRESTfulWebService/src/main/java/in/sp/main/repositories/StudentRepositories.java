package in.sp.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.Student;

public interface StudentRepositories extends JpaRepository<Student, Integer>{
}
