package com.thoughtworks.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class StudentApplication {
	public static Set<Student> students = new HashSet<>();

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
