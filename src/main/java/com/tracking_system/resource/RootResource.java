package com.tracking_system.resource;


import com.tracking_system.model.Root;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.RootDetails;
import com.tracking_system.repository.RootRepo;
import com.tracking_system.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trackingsystem/root")
public class RootResource {

    @Autowired
    private RootRepo rootRepo;

    @Autowired
    private RootService rootService;

    //Get All Root By Page
    @GetMapping("/all")
    public List<Root> getAllRoot(@RequestParam("page") int page) {
        return rootService.getAllRoot(page);
    }

    //Creating Root
    @PostMapping(value = "/createRoot")
    public ResponseEntity createRoot(@Valid @RequestBody final RootDetails rootDetails){

        if(rootRepo.existsByRootId(rootDetails.getRootId())) {

            return new ResponseEntity(new ApiResponse(false, "Bus No is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        Root root = new Root(rootDetails.getRootId(),rootDetails.getRootFrom(),rootDetails.getRootTo(),
                             rootDetails.getRootinstitutionId());
        Root result = rootRepo.save(root);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/getRootFrom/{rootfrom}")
                .buildAndExpand(result.getRootId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, " successfully"));
    }

    //Updating Root
    @PutMapping(value = "/update/{rootid}")
    public Root updateByRootId(@PathVariable (value = "rootid") Integer rootid, @RequestBody Root root){
        rootRepo.findById(rootid);
        return rootRepo.save(root);
    }

    //Deleting Root
    @DeleteMapping(value = "/delete/{rootid}")
    public ResponseEntity deleteByRootId(@PathVariable("rootid") Integer rootid, @RequestBody Root root) {
        rootRepo.delete(root);
        return ResponseEntity.noContent().build();
    }
}
