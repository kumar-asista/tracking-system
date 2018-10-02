package com.tracking_system.service;

import com.tracking_system.model.User;
import com.tracking_system.repository.UserRepo;
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
public class UserService{

       @Value("3")
    	private int limit;

    	@Autowired
	    private UserRepo userRepo;


    	public List<User> getAllUser(int page) {
		    List<User> userList = new ArrayList<User>();
		    if (page <= 0) {
			page = 1;
		    }
		    Pageable pageRequest = new PageRequest(--page, limit, Sort.Direction.ASC,"username");
		    Page<User> pageUser = userRepo.findAll(pageRequest);
		    for (User user : pageUser) {
			userList.add(user);
		    }
		    return userList;
	    }
}