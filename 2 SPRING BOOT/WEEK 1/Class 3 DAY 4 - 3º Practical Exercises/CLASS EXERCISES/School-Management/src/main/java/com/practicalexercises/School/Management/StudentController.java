package com.practicalexercises.School.Management;

import com.practicalexercises.School.Management.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> students = new ArrayList<>();

    @PostMapping("/student")
    public String createStudent(@RequestBody Student student) {
        if (student.getEducationalLevel().equalsIgnoreCase(
                "Primary") || student.getEducationalLevel().equalsIgnoreCase(
                "Secondary") || student.getEducationalLevel().equalsIgnoreCase(
                "Tertiary")) {
            students.add(student);
            return "Student created";
        } else {
            return "No valid level Education, please enter primary, secondary" +
                    " or tertiary";
        }
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }


    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return students.stream().filter(
                student -> student.getId() == id).findFirst().orElse(null);
    }

    @GetMapping("/studentLevel/{level}")
    public List<Student> getStudent(@PathVariable String level) {
        return students.stream().filter(
                student -> student.getEducationalLevel().equalsIgnoreCase(level))
                        .collect(Collectors.toList());
    }


}
