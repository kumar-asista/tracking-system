package com.tracking_system.resource;

import com.tracking_system.model.Locations;
import com.tracking_system.model.Root;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.payload.LocationDetails;
import com.tracking_system.repository.LocationsRepo;
import com.tracking_system.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.stream.Location;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trackingsystem/location")
public class LocationResource {

    @Autowired
    private LocationsRepo locationsRepo;

    @Autowired
    private LocationService locationService;

    //Get All Location By Page
    @GetMapping("/all")
    public List<Locations> getAllLocations(@RequestParam("page") int page, @RequestParam ("limit") int limit) {
        return locationService.getAllLocations(page, limit);
    }

    //Creating Location
    @PostMapping(value = "/create")
    public ResponseEntity createLocation(@Valid @RequestBody final LocationDetails locationDetails) {

        Locations locations = new Locations(locationDetails.getLocationid(), locationDetails.getLatitude(),
                locationDetails.getLongitude(), locationDetails.getRootid());
        locationsRepo.save(locations);

        return ResponseEntity.ok(locations);
    }

    @GetMapping("/findLocationByRootId")
    public Locations recentLocationByRootId(@RequestParam("rootid") int rootid){

       return locationService.findLocationByRoot(rootid);
    }
}
