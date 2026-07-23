package com.example.StudentManagement.Service;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    //Student REpository reference
    //Student REpository reference2
    private StudentRepository studentRepo;

    public Student createStudent(Student student){
        Student student1 = studentRepo.save(student);
        return student1;
    }
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public String getStudentById(Long id){
        Optional<Student> student1=studentRepo.findById(id);
        if(student1.isPresent()){
            return "Student found";
        }
        else{
            return "student not found";
        }

    }
    public String updateFullStudent(Long id,Student student){
        Optional<Student> student1=studentRepo.findById(id);
        if(student1.isPresent()){
            studentRepo.save(student);
            return "student updated successfully";
        }
        else{
            return "student updation failed";
        }

    }
    public String updatePartialStudent(Long id,int age){
        Optional<Student> student2=studentRepo.findById(id);
        if(student2.isPresent()){
            student2.get().setAge(age);
            studentRepo.save(student2.get());
            return "Student age updated successfully";
        }
        else{
            return "student updation failed";
        }
    }
    public String deleteStudent(Long id){
        Optional<Student> student3 = studentRepo.findById(id);
        if(student3.isPresent()){
            studentRepo.deleteById(id);
            return "student deleted successfully";
        }
        else{
            return "student deletion failed";
        }
    }



}
