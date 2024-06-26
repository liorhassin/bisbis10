package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.RatingDTO;
import com.att.tdp.bisbis10.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    ResponseEntity<?> addRating(@RequestBody RatingDTO ratingDTO){
        ratingService.addRating(ratingDTO);
        return ResponseEntity.ok(null);
    }
}
