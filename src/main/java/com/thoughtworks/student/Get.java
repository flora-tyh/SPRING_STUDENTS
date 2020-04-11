package com.thoughtworks.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class Get {
    @GetMapping("/get/students")
    public String getAllStudents() {
        String studentsInfo = StudentApplication.students.stream()
                .map(s -> "学生姓名:" + s.getName() + " 性别:" + s.getGender() + " 班级:" + s.getClassName())
                .collect(Collectors.joining("<------------>"));
        return studentsInfo;
    }

    @GetMapping("/get/{name}")
    public String getStudentByName(@PathVariable String name) {
        Student student = StudentApplication.students.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if(student == null) {
            return "没有该学生";
        }
        return "学生姓名:" + student.getName() + " 性别:" + student.getGender() + " 班级:" + student.getClassName();
    }

    @GetMapping("/delete/{name}")
    public String deleteStudentByName(@PathVariable String name) {
        Student student = StudentApplication.students.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if(student == null) {
            return "没有该学生";
        }
        StudentApplication.students.remove(student);
        return "删除成功";
    }
}
