package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Orders, UUID> {
}
