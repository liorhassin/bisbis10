package com.att.tdp.bisbis10.dto;

import java.util.List;

public record RestaurantDTO(String name, Boolean isKosher, List<String> cuisines) {
}
