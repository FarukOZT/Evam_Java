package com.bootcamp.evam_java.controllers;

import com.bootcamp.evam_java.entity.Bill;
import com.bootcamp.evam_java.services.BillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }
    @PostMapping("/add")
    public Bill addBill(@RequestBody Bill bill){
        return billService.addBill(bill);
    }

}
