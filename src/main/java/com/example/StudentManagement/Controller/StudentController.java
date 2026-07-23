package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Repository.StudentRepository;
import com.example.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/StudentManagement")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();

    }
    @GetMapping("/getStudent/{id}")
    public String getStudentById(@PathVariable Long id){

        return studentService.getStudentById(id);
    }
    @PutMapping("/fullUpdation/{id}")
    public String updateFullDetails(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateFullStudent(id, student);
    }
    @PatchMapping("/partialUpdation/{id}/{age}")
    public String updatePartialDetails(@PathVariable Long id, @PathVariable int age){
        return studentService.updatePartialStudent(id, age);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){

        return studentService.deleteStudent(id);
    }

}
