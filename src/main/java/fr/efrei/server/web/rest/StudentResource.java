package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    // READ-All Controller
    @GetMapping ("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    // READ student based on ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id) {

        Integer parsedId;

        // Parsing the id into Integer
        try {
            // Setting the id
            parsedId = Integer.parseInt(id);

        }catch (NumberFormatException e){
            // Setting the id by default
            parsedId = 0;
        }

        // Getting the Student entity in the service
        Student student = studentService.getStudentById(parsedId);

        return student;
    }

    @GetMapping("/student/create/np/{name}/{age}")
    public Student createStudentById(@PathVariable String name, @PathVariable Integer age) {
        // Creating the new student
        Student student = new Student();

        // Adding its passed-down variables
        student.setName(name);
        student.setAge(age);

        Student createdStudent = studentService.createStudent(student);
        return createdStudent;
    }

    // For PUT and DELETE we use a postman web extension to make the queries
    // UPDATE student base on ID for Name and Age
    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestParam String name, @RequestParam Integer age) {
        Student student = studentService.updateStudent(id, name, age);
        return student;
    }

    // DELETE student based on ID
    @DeleteMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        Integer response = studentService.deleteStudent(id);
        return "done";
    }

}