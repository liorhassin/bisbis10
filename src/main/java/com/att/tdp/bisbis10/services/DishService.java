package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

}
