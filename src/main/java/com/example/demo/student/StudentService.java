/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author ryota
 */
//@Component
//we can use @Componnet but to be more specefic we do use @Service

@Service
public class StudentService{
    
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    public List<Student> getStudents(){
            return studentRepository.findAll();
        }
    
   public void addNewStudent(Student student){
       Optional<Student> studentOptional=  studentRepository.findStudentByEmail(student.getEmail());
       if(studentOptional.isPresent()){
           throw new IllegalStateException("email token");
       }
       
       studentRepository.save(student);
   } 
   
   public void deleteStudent(Long studentId){
       
       boolean exists = studentRepository.existsById(studentId);
       
       if(!exists){
           throw new IllegalStateException("student whith id"+ studentId+ "does not exists");
           
           
       }
       
       studentRepository.deleteById(studentId);
   }
   
   @Transactional
   public void updateStudent(Long studentId, String name , String email){
       Student student = studentRepository.findById(studentId).orElseThrow(
               ()-> new IllegalStateException(
                       "student with id "+ studentId + "does not exists"
               ));
       
       if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
           student.setName(name);
       }
       
       if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
           Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
           if(studentOptional.isPresent()){
               throw new IllegalStateException("email taken");
           }
           student.setEmail(email);
       }
   }
}
