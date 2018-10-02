package com.tracking_system.resource;

import com.tracking_system.exception.ResourceNotFoundException;
import com.tracking_system.model.Bus;
import com.tracking_system.model.User;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.BusDetails;
import com.tracking_system.repository.BusRepo;
import com.tracking_system.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/*
* TODO dynamic mapping bus institution
* */

@RestController
@RequestMapping(value = "/trackingsystem/bus")
public class BusResource {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private BusService busService;

    //Get All Bus By Page
    @GetMapping("/all")
    public List<Bus> getAllBus(@RequestParam("page") int page) {
        return busService.getAllBus(page);
    }

    //Creating Bus
    @PostMapping(value = "/createBus")
    public ResponseEntity createBus(@Valid @RequestBody final BusDetails busDetails){

        if(busRepo.existsByBusNo(busDetails.getBusNo())) {

            return new ResponseEntity(new ApiResponse(false, "Bus No is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        Bus bus = new Bus(busDetails.getBusNo(),busDetails.getBusinstitutionId(),busDetails.getRootid());
        Bus result = busRepo.save(bus);


        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/busByBusNo/{busNo}")
                .buildAndExpand(result.getBusNo()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, " successfully"));
    }

    //Updating User
    @PutMapping(value = "/update/{busNo}")
    public Bus updateByBusNo(@PathVariable (value = "busNo") Long busNo, @RequestBody Bus bus){
        busRepo.findById(busNo);
        return busRepo.save(bus);
    }

    //Deleting Bus
    @DeleteMapping(value = "/delete/{busNo}")
    public ResponseEntity deleteByBus(@PathVariable("busNo") Long busNo, @RequestBody Bus bus) {
        busRepo.delete(bus);
        return ResponseEntity.noContent().build();
    }
}

