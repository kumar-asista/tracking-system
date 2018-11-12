package com.tracking_system.service;

import com.tracking_system.model.Student;
import com.tracking_system.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getAllStudent(int page, int limit) {
        List<Student> studentList = new ArrayList<Student>();
        if (page <= 0) {
            page = 1;
        }
        if (limit <= 5) {
            limit = 5;
        }
        Pageable pageRequest = new PageRequest(--page, limit, Sort.Direction.ASC,"registerno");
        Page<Student> pageStudent = studentRepo.findAll(pageRequest);
        for (Student student : pageStudent) {
            studentList.add(student);
        }
        return studentList;
    }
}
