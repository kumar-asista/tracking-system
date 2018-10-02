package com.tracking_system.resource;

import com.tracking_system.model.Institution;
import com.tracking_system.repository.InstitutionRepo;
import com.tracking_system.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Dynamic code have to apply here for mapping institution and user

@RestController
@RequestMapping(value = "/trackingsystem/institution")
public class InstitutionResource  {

    @Autowired
    private InstitutionRepo institutionRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/all")
    public List<Institution> getAll(){
        return institutionRepo.findAll();

    }

    @PostMapping(value = "/create")
    public Institution create(@RequestBody final Institution institution){
        return institutionRepo.save(institution);
    }


}
