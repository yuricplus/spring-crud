package com.project.crudspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudspring.model.Course;
import com.project.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping("list")
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("item")
    public Optional<Course> getById(@RequestParam("id") Long id) {
        return courseRepository.findById(id);
    }

    @PostMapping(value="item")
    public ResponseEntity<?> createCourse(@RequestBody Course data) {
        try {
            courseRepository.save(data);
            return new ResponseEntity(null, HttpStatus.OK);        
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);  
        }
    
    }
    
    

    
}
