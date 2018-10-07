package com.tracking_system.resource;

import com.tracking_system.exception.ResourceNotFoundException;
import com.tracking_system.model.User;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.SignUpRequest;
import com.tracking_system.payload.UserProfile;
import com.tracking_system.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trackingsystem/user")
public class UserResource {


    @Autowired
    private UserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);


    //Sign Up
    @PostMapping(value = "/signUp")
    public ResponseEntity registerUser(@Valid @RequestBody final SignUpRequest signUpRequest) {

        if (userRepo.existsByPhoneNo(signUpRequest.getPhoneNo())) {

            return new ResponseEntity(new ApiResponse(false, "User is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        //Creating User
        User user = new User(signUpRequest.getPhoneNo(),
                signUpRequest.getFirstname(),
                signUpRequest.getLastname(),
                signUpRequest.getEnable(),
                signUpRequest.getRoleId());

        User result = userRepo.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{phoneNo}")
                .buildAndExpand(result.getPhoneNo()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

    }

    //Get All By Page
    @GetMapping(value = "/all")
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    //List userByUsername
    @GetMapping("user/{phoneNo}")
    public UserProfile getUserProfile(@PathVariable(value = "phoneNo") Long phoneNo, @RequestBody User user) {
        userRepo.findById(phoneNo);
        UserProfile userProfile = new UserProfile(user.getPhoneNo(), user.getFirstname(), user.getLastname(),
                user.getEnable(), user.getRoleId());
        return userProfile;
    }

    //Updating User
    @PutMapping(value = "/update/{phoneNo}")
    public ResponseEntity updateUser(@PathVariable(value = "phoneNo") Long phoneNo, @RequestBody User user) {
        if (userRepo.existsByPhoneNo(user.getPhoneNo())) {
            userRepo.findById(phoneNo);
            userRepo.save(user);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity(new ApiResponse(false, "User is not available!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //Deleting User
    @DeleteMapping(value = "/delete/{phoneNo}")
    public ResponseEntity deleteUser(@PathVariable("phoneNo") Long phoneNo, @RequestBody User user) {
        if (userRepo.existsByPhoneNo(user.getPhoneNo())) {
            userRepo.deleteById(phoneNo);
        }
        else{
            return new ResponseEntity(new ApiResponse(false, "User is not available!"),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().build();
    }

}
