package com.tracking_system.service;

import com.tracking_system.model.Bus;
import com.tracking_system.model.User;
import com.tracking_system.repository.BusRepo;
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
public class BusService {

    @Value("2")
    private int limit;

    @Autowired
    private BusRepo busRepo;

    public List<Bus> getAllBus(int page) {
        List<Bus> busList = new ArrayList<Bus>();
        if (page <= 0) {
            page = 1;
        }
        Pageable pageRequest = new PageRequest(--page, limit, Sort.Direction.ASC,"busNo");
        Page<Bus> pageBus = busRepo.findAll(pageRequest);
        for (Bus bus : pageBus) {
            busList.add(bus);
        }
        return busList;
    }

}
