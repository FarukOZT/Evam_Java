package com.bootcamp.evam_java.controllers;

import com.bootcamp.evam_java.entity.Bill;
import com.bootcamp.evam_java.entity.PaymentReq;
import com.bootcamp.evam_java.entity.PaymentRes;
import com.bootcamp.evam_java.entity.User;
import com.bootcamp.evam_java.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/{userId}/{billId}")
    public Long makePayment(@PathVariable ("userId") Long userId,
                            @PathVariable ("billId") Long billId){
        paymentService.makePayment(userId,billId);
        return billId;
    }
    @PostMapping("/pays/")
    public List<PaymentReq> payment2(@RequestBody List<PaymentRes> billId){

        return paymentService.payment2(billId);
    }

}
