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

    @Autowired
    private StudentService studentService;


    //Get All By Page
    @GetMapping(value = "/all")
    public List<Student> getAllStudent(@RequestParam("page") int page) {
        return studentService.getAllStudent(page);
    }

    //Create Student
    @PostMapping(value = "/create")
    public ResponseEntity registerStudent(@Valid @RequestBody final StudentProfile studentProfile){

        if(studentRepo.existsByRegisterno(studentProfile.getRegisterno())) {

            return new ResponseEntity(new ApiResponse(false, "Register No is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        //Creating Student
        Student student = new Student(studentProfile.getRegisterno(),studentProfile.getFirstname(),
                                        studentProfile.getLastname(),studentProfile.getClassname(),
                                        studentProfile.getSec(),studentProfile.getParentname(),
                                        studentProfile.getPhoneno(),studentProfile.getAddrs(),
                                        studentProfile.getRootid());

        Student result = studentRepo.save(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{firstname}")
                .buildAndExpand(result.getFirstname()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Student registered successfully"));
    }

    //List StudentByFirstName
    @GetMapping("/{firstname}")//working
    public StudentProfile getStudentProfile(@PathVariable(value = "firstname") String firstname) {
        Student student = studentRepo.findByFirstname(firstname)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "firstname", firstname));

        StudentProfile studentProfile = new StudentProfile(student.getRegisterno(),student.getFirstname(),student.getLastname(),
                                                           student.getClassname(),student.getSec(),student.getParentname(),
                                                           student.getPhoneno(),student.getAddrs(),student.getRootid());

        return studentProfile;
    }


    //Updating Student
    @PutMapping(value = "/update/{registerno}")
    public Student updateByRegisterNo(@PathVariable (value = "registerno") Integer registerno, @RequestBody Student student){
        studentRepo.findById(registerno);
        return studentRepo.save(student);
    }

    //Deleting Student
    @DeleteMapping(value = "/delete/{registerno}")
    public ResponseEntity deleteByStudent(@PathVariable("registerno") Integer registerno, @RequestBody Student student) {
        studentRepo.delete(student);
        return ResponseEntity.noContent().build();
    }

}
