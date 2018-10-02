package com.tracking_system.resource;

import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.DriverDetails;
import com.tracking_system.repository.DriverRepo;
import com.tracking_system.service.DriverService;
import com.tracking_system.model.Drivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;




@RestController
@RequestMapping(value = "/trackingsystem/driver")
public class DriverResource {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private DriverService driverService;

    //Get All Bus By Page
    @GetMapping("/all")
    public List<Drivers> getAllDriver(@RequestParam("page") int page) {
        return driverService.getAllDriver(page);
    }

    //Creating Driver
    @PostMapping(value = "/createDriver")
    public ResponseEntity createDriver(@Valid @RequestBody final DriverDetails driverDetails){

        if(driverRepo.existsByDriverLicenseNo(driverDetails.getDriverLicenseNo())) {

            return new ResponseEntity(new ApiResponse(false, "DriverLicenseNo is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        Drivers drivers = new Drivers(driverDetails.getDriverLicenseNo(),driverDetails.getDriver_name(),
                                        driverDetails.getDriverinstitutionId(),driverDetails.getDriverbusNo());
        Drivers result = driverRepo.save(drivers);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/all")
                .buildAndExpand(result.getDriverLicenseNo()).toUri();

        return ResponseEntity.created(location).body    (new ApiResponse(true, " successfully"));
    }

    //Updating Driver
    @PutMapping(value = "/update/{driverLicenseNo}")
    public Drivers updateByDriverNo(@PathVariable (value = "driverLicenseNo") Long driverLicenseNo, @RequestBody Drivers drivers){
        driverRepo.findById(driverLicenseNo);
        return driverRepo.save(drivers);
    }

    //Deleting Bus
    @DeleteMapping(value = "/delete/{driverLicenseNo}")
    public ResponseEntity deleteByDriver(@PathVariable("driverLicenseNo") Long driverLicenseNo, @RequestBody Drivers drivers) {
        driverRepo.delete(drivers);
        return ResponseEntity.noContent().build();
    }


}
