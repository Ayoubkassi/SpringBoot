/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ryota
 */
@Configuration
public class StudentConfig {
    
    @Bean
            //we add bean so that can be running
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args-> {
           Student ayoub = new Student(
                "AyoubKassi",
                 LocalDate.of(2000,7,2),
                 "ayoub.kassi@uit.ac.ma"
            );
           Student maroua = new Student(
    
                "MarouaNufi",
                 LocalDate.of(2000,5,13),
                 "maroua.elazzaoui@uit.ac.ma"
            );
           
           repository.saveAll(
                   List.of(ayoub,maroua)
           );
        };
    }
}
