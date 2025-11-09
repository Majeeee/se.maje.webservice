package se.maje.WebService_Uppgifter_Lektion_7.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.maje.WebService_Uppgifter_Lektion_7.model.Student;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);
}
