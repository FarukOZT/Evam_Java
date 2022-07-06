package com.bootcamp.evam_java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class PaymentReq {

    private Long userId;
    private Long billId;
    private Double wallet;
    private Double price;

    public PaymentReq(Long userId, Long billId, Double result) {

    }
}
