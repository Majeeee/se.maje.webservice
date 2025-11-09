package se.maje.WebService_Uppgifter_Lektion_7.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.maje.WebService_Uppgifter_Lektion_7.model.Student;
import se.maje.WebService_Uppgifter_Lektion_7.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/students")
    public class StudentController {

        private final StudentRepository studentRepository;

        @Autowired
        public StudentController(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

        @GetMapping
        public List<Student> getAllStudents() {
            return studentRepository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getStudentById(@PathVariable Long id) {
            Optional<Student> student = studentRepository.findStudentById(id);

            if (student.isPresent()) {
                return ResponseEntity.ok(student.get());
            } else {
                return ResponseEntity.status(404)
                        .body("Student med ID " + id + " finns inte.");
            }
        }
    }


