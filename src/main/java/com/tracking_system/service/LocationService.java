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

    @Value("2")
    private int limit;

    @Autowired
    private LocationsRepo locationsRepo;

    public List<Locations> getAllLocations(int page) {
        List<Locations> locationsList = new ArrayList<Locations>();
        if (page <= 0) {
            page = 1;
        }
        Pageable pageRequest = new PageRequest(--page, limit, Sort.Direction.ASC,"locId");
        Page<Locations> pageLocations = locationsRepo.findAll(pageRequest);
        for (Locations locations : pageLocations) {
            locationsList.add(locations);
        }
        return locationsList;
    }
}
