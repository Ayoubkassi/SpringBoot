/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
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
    public List<Student> getStudents(){
            return List.of(
                  new Student(
                          1L,
                          "AyoubKassi",
                          21,
                          LocalDate.of(2000,7,2),
                          "ayoub.kassi@uit.ac.ma"
                  )  
            );
        }
    
   
}
