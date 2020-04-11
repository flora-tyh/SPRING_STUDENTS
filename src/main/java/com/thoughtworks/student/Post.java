package com.thoughtworks.student;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Post {
    @PostMapping("/p")
    public String post(@RequestBody Student student) {
        if (StudentApplication.students.add(student)) {
            return "添加成功";
        } else {
            return "姓名重复";
        }
    }
}
