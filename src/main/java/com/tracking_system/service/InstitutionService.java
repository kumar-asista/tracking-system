package com.tracking_system.service;

import com.tracking_system.model.Institution;
import com.tracking_system.repository.InstitutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepo institutionRepo;

    public List<Institution> getAllInstitution(int page, int limit) {
        List<Institution> institutions = new ArrayList<Institution>();
        if (page <= 0) {
            page = 1;
        }
        if (limit <= 0) {
            limit = 5;
        }
        Pageable pageRequest = new PageRequest(--page, limit, Sort.Direction.ASC,"institutionId");
        Page<Institution> institutionPage = institutionRepo.findAll(pageRequest);
        for (Institution institution : institutionPage) {
            institutions.add(institution);
        }
        return institutions;
    }
}
