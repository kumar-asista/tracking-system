package com.tracking_system.resource;

import com.tracking_system.exception.ResourceNotFoundException;
import com.tracking_system.model.Student;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.StudentProfile;
import com.tracking_system.repository.StudentRepo;
import com.tracking_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trackingsystem/student")
public class StudentResource {

    @Autowired
    private StudentRepo studentRepo;

    //    @Autowired
    //    private StudentService studentService;


    //Get All By Page
    @GetMapping(value = "/all")
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    //Create Student
    @PostMapping(value = "/create")
    public ResponseEntity registerStudent(@Valid @RequestBody final StudentProfile studentProfile){

        if(studentRepo.existsByRegisterno(studentProfile.getRegisterno())) {

            return new ResponseEntity(new ApiResponse(false, "Register No is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        //Creating Student
        Student student = new Student(studentProfile.getStudentId(),studentProfile.getFirstname(),
                                      studentProfile.getLastname(),studentProfile.getClassname(),
                                      studentProfile.getSection(),studentProfile.getParentname(),
                                      studentProfile.getPhoneno(),studentProfile.getAddress(),
                                      studentProfile.getRootid(),studentProfile.getIsenable(),
                                      studentProfile.getRegisterno());

        Student result = studentRepo.save(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{registerno}")
                .buildAndExpand(result.getFirstname()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Student registered successfully"));
    }

    //List StudentByRegisterNo
    @GetMapping("/{registerno}")//working
    public StudentProfile getStudentProfile(@PathVariable(value = "registerno") String registerno) {
        Student student = studentRepo.findByRegisterno(registerno)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "register", registerno));

        StudentProfile studentProfile = new StudentProfile(student.getStudentId(),student.getFirstname(),student.getLastname(),
                                                           student.getClassname(),student.getSection(),student.getParentname(),
                                                           student.getPhoneno(),student.getAddress(),student.getRootid(),
                                                           student.getIsenable(),student.getRegisterno());

        return studentProfile;
    }


    //Updating Student
    @PutMapping(value = "/update/{registerno}")
    public ResponseEntity updateStudent(@PathVariable(value = "registerno") String registerno, @RequestBody Student student){
        if (studentRepo.existsByRegisterno(student.getRegisterno())) {
            studentRepo.findByRegisterno(registerno);
            studentRepo.save(student);
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return new ResponseEntity(new ApiResponse(false, "Student is not available!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //Deleting Student
    @DeleteMapping(value = "/delete/{registerno}")
    public ResponseEntity deleteByStudent(@PathVariable("registerno") String registerno, @RequestBody Student student) {
        if (studentRepo.existsByRegisterno(student.getRegisterno())) {
            studentRepo.findByRegisterno(registerno);
            studentRepo.delete(student);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(new ApiResponse(false, "Student is not available!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

}
