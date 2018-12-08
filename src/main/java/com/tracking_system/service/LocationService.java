package com.tracking_system.service;

import com.tracking_system.model.Locations;
import com.tracking_system.model.Root;
import com.tracking_system.repository.LocationsRepo;
import com.tracking_system.repository.RootRepo;
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
public class LocationService {


    @Autowired
    private LocationsRepo locationsRepo;

    public List<Locations> getAllLocations(int page, int limit) {
        List<Locations> locationsList = new ArrayList<Locations>();
        if (page <= 0) {
            page = 1;
        }
        if (limit <= 0) {
            limit = 5;
        }
        Pageable pageRequest = new PageRequest(--page, limit );//;Sort.Direction.ASC,"loc_id");
        Page<Locations> pageLocations = locationsRepo.findAll(pageRequest);
        for (Locations locations : pageLocations) {
            locationsList.add(locations);
        }
        return locationsList;
    }

    public Locations findLocationByRoot(int rootid){
        Locations locations = locationsRepo.findLocationByRoot(rootid);
        return locations;
    }

}
