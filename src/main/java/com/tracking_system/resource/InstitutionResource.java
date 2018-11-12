package com.tracking_system.resource;

import com.tracking_system.model.Institution;
import com.tracking_system.payload.ApiResponse;
import com.tracking_system.repository.InstitutionRepo;
import com.tracking_system.repository.UserRepo;
import com.tracking_system.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Dynamic code have to apply here for mapping institution and user

@RestController
@RequestMapping(value = "/trackingsystem/institution")
public class InstitutionResource  {

    @Autowired
    private InstitutionRepo institutionRepo;

    @Autowired
    private InstitutionService institutionService;

    @GetMapping(value = "/all")
    public List<Institution> getAllInstitution(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return institutionService.getAllInstitution(page, limit);
    }

    @PostMapping(value = "/create")
    public Institution create(@RequestBody final Institution institution){
        return institutionRepo.save(institution);
    }

    @PutMapping(value = "/update/{institutionid}")
    public ResponseEntity updateInstitution(@PathVariable(value = "institutionid") Integer institutionid, @RequestBody Institution institution){
        if(institutionRepo.existsByInstitutionId(institution.getInstitutionId())){
            institutionRepo.findById(institutionid);
            institutionRepo.save(institution);
            return ResponseEntity.ok(HttpStatus.OK);
        }else{
            return new ResponseEntity(new ApiResponse(false,"Institutionis not available"),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{institutionid}")
    public ResponseEntity deleteByInstitution(@PathVariable("institutionid") Integer institutionid, @RequestBody Institution institution){
        if(institutionRepo.existsByInstitutionId(institution.getInstitutionId())){
            institutionRepo.findById(institutionid);
            institutionRepo.delete(institution);
            return ResponseEntity.ok(HttpStatus.OK);
        }else{
            return new ResponseEntity(new ApiResponse(false,"Institution is not available"),
                    HttpStatus.BAD_REQUEST);
        }

    }
}
