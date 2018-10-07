package com.tracking_system.resource;


import com.tracking_system.model.Root;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.RootDetails;
import com.tracking_system.repository.RootRepo;
import com.tracking_system.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trackingsystem/root")
public class RootResource{

    @Autowired
    private RootRepo rootRepo;

    //Get All Roots By Page
    @GetMapping("/all")
    public List<Root> getAllRoot() {
        return rootRepo.findAll();
    }

    //Creating Roots
    @PostMapping(value = "/create")
    public ResponseEntity createRoot(@Valid @RequestBody final RootDetails rootDetails){

        if(rootRepo.existsByRootId(rootDetails.getRootId())) {

            return new ResponseEntity(new ApiResponse(false, "Root Id is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        Root root = new Root(rootDetails.getRootId(),rootDetails.getRootFrom(),rootDetails.getRootTo(),rootDetails.getRootinstitutionId(),
                             /*rootDetails.getFromLatitude(),rootDetails.getFromLongitude(),rootDetails.getToLatiutde(),rootDetails.getToLongitude(),*/
                             rootDetails.getBusno(),rootDetails.getDriverLicenseNo(),rootDetails.getDriverName(),rootDetails.getDriverPhoneNo());
        Root result = rootRepo.save(root);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("")
                .buildAndExpand(result.getRootId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, " successfully"));
    }

    //Updating Roots
    @PutMapping(value = "/update/{rootId}")
    public ResponseEntity updateRootId(@PathVariable (value = "rootId") Integer rootId, @RequestBody Root root){
        if(rootRepo.existsByRootId(root.getRootId())){
            rootRepo.findById(rootId);
            rootRepo.save(root);
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            return new ResponseEntity(new ApiResponse(false, "User is not available!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    //Deleting Roots
    @DeleteMapping(value = "/delete/{rootId}")
    public ResponseEntity deleteRootId(@PathVariable("rootId") Integer rootId, @RequestBody Root root) {
       if(rootRepo.existsByRootId(root.getRootId())) {
           rootRepo.delete(root);
           return ResponseEntity.ok(HttpStatus.OK);
       }
       else{
           return new ResponseEntity(new ApiResponse(false, "Root is not available!"),
                   HttpStatus.BAD_REQUEST);

       }
    }
}
