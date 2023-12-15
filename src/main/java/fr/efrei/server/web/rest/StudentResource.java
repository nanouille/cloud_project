package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping ("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable String id) {
        // Creating the Student entity
        Student student = new Student();

        // Setting the id (with Exception-Handling)
        try {
            // Setting the id
            student.setId(Integer.parseInt(id));

        }catch (NumberFormatException e){

            // Affecting the ID automatically in case
            student.setId(100);
        }

        // Setting the name
        student.setName("Elena");

        // Setting the age
        student.setAge(22);

        return student;
    }

}