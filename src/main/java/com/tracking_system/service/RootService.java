package com.tracking_system.service;

import com.tracking_system.model.Root;
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
public class RootService {

    @Value("2")
    private int limit;

    @Autowired
    private RootRepo rootRepo;

    public List<Root> getAllRoot(int page) {
        List<Root> rootList = new ArrayList<Root>();
        if (page <= 0) {
            page = 1;
        }
        Pageable pageRequest = new PageRequest(--page, limit, Sort.Direction.ASC,"rootId");
        Page<Root> pageRoot = rootRepo.findAll(pageRequest);
        for (Root root : pageRoot) {
            rootList.add(root);
        }
        return rootList;
    }
}
