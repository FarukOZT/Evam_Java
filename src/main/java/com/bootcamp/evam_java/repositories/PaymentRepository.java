package com.bootcamp.evam_java.repositories;

import com.bootcamp.evam_java.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Bill,Long> {
}
