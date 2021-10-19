package com.example.demo;

import com.example.demo.student.Student;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        
            
       

        
        @GetMapping
        public List<Student> hello(){
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
