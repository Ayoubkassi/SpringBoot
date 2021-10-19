/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ryota
 */
@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    
      @GetMapping
        public List<Student> getStudent(){
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
