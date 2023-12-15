package fr.efrei.server.service;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // READ-All Service
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // READ-One Service
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    // CREATE Service
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    // UPDATE Service
    public Student updateStudent(Integer id, String name, Integer age){
        // Getting the student
        Student existingStudent = studentRepository.findById(id)
                .orElse(null);

        // Setting the found student
        if(existingStudent!=null) {
            existingStudent.setName(name);
            existingStudent.setAge(age);
            return studentRepository.save(existingStudent);
        }

        // If student not found
        return null;
    }

    // DELETE Service
    public Integer deleteStudent(Integer id){
        // Getting the student
        Student existingStudent = studentRepository.findById(id)
                .orElse(null);

        // Deleting the student
        if(existingStudent!=null) {
            studentRepository.delete(existingStudent);
            return 1;
        }

        // If student not found
        return 0;
    }



}