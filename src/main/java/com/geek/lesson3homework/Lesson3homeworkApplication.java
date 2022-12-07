package com.geek.lesson3homework;

import com.geek.lesson3homework.model.Product;
import com.geek.lesson3homework.repository.InMemoryProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class Lesson3homeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson3homeworkApplication.class, args);
	}

}
