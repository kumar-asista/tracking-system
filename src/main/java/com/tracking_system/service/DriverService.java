package com.tracking_system.service;

import com.tracking_system.model.Drivers;
import com.tracking_system.repository.DriverRepo;
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
public class DriverService {

    @Value("2")
    private int limit;

    @Autowired
    private DriverRepo driverRepo;

    public List<Drivers> getAllDriver(int page) {
        List<Drivers> driversList = new ArrayList<Drivers>();
        if (page <= 0) {
            page = 1;
        }
        Pageable pageRequest = new PageRequest(--page, limit, Sort.Direction.ASC,"driverLicenseNo");
        Page<Drivers> pageDriver = driverRepo.findAll(pageRequest);
        for (Drivers drivers : pageDriver) {
            driversList.add(drivers);
        }
        return driversList;
    }
}
