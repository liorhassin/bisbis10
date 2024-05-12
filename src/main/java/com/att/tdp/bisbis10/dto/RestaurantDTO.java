package com.att.tdp.bisbis10.dto;

import java.util.List;

public record RestaurantDTO(Long id, String name,Float averageRating, Boolean isKosher, List<String> cuisines) {
}
