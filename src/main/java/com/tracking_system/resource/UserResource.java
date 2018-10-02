package com.tracking_system.resource;

import com.tracking_system.exception.AppException;
import com.tracking_system.exception.ResourceNotFoundException;
import com.tracking_system.model.Role;
import com.tracking_system.model.RoleName;
import com.tracking_system.model.User;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.SignUpRequest;
import com.tracking_system.payload.UserProfile;
import com.tracking_system.repository.RoleRepo;
import com.tracking_system.repository.UserRepo;
import com.tracking_system.service.UserService;
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
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);


    //Sign Up
    @PostMapping(value = "/signup")
    public ResponseEntity registerUser(@Valid @RequestBody final SignUpRequest signUpRequest){

        if(userRepo.existsByUsername(signUpRequest.getUsername())) {

            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                                                        HttpStatus.BAD_REQUEST);
        }

        //Creating User
        User user = new User(signUpRequest.getUsername(),
                             signUpRequest.getFirstname(),
                             signUpRequest.getLastname(),
                             signUpRequest.getPhoneNo(),
                             signUpRequest.getEnable(),
                             signUpRequest.getRoleId());

        User result = userRepo.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

    }

    //Get All By Page
    @GetMapping(value = "/all")
    public List<User> getAllUser(@RequestParam("page") int page) {
        return userService.getAllUser(page);
    }

    //List userByUsername
    @GetMapping("/users/{username}")//working
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(user.getUsername(), user.getPhoneNo(), user.getEnable(),
                                                  user.getFirstname(),user.getLastname(),user.getRoleId());

        return userProfile;
    }

    //Updating User
    @PutMapping(value = "/update/{username}")
    public ResponseEntity updateByUsername(@PathVariable (value = "username") String username){
        User user = this.userRepo.findByUsername(username).orElseThrow(() -> {
            return new ResourceNotFoundException("User", "username", username); });
        this.userRepo.save(user);
        this.userRepo.findByUsername(username);
        return ResponseEntity.noContent().build();


    }

    //Deleting User
    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity deleteByUsername(@PathVariable("username") String username) {
        User user = this.userRepo.findByUsername(username).orElseThrow(() -> {
                    return new ResourceNotFoundException("User", "username", username); });
        this.userRepo.delete(user);
        return ResponseEntity.noContent().build();
    }

    //Disable or Enable User By Username
    @PutMapping("enable/{username}")//working
    public User disableorEnableByUser(@PathVariable(value = "username") String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        if(user.getEnable()==false)
                user.setEnable(true);
        if(user.getEnable()==true)
            user.setEnable(false);

        return userRepo.save(user);
    }

}
