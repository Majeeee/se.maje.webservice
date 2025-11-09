package se.maje.WebService_Uppgifter_Lektion_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.maje.WebService_Uppgifter_Lektion_8.model.Student;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);
}