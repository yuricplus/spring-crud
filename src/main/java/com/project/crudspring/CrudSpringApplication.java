package com.project.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.crudspring.model.Course;
import com.project.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();
			Course c = new Course();
			Course b = new Course();

			c.setCategory("Front End");
			c.setName("Angular");

			b.setCategory("Back End");
			b.setName("Spring+Java");
			courseRepository.save(b);
			courseRepository.save(c);


		};
	}

}
