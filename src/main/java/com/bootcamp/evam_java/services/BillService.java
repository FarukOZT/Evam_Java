package com.bootcamp.evam_java.services;

import com.bootcamp.evam_java.entity.Bill;
import com.bootcamp.evam_java.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;
    private final UserService userService;

    public BillService(BillRepository billRepository, UserService userService) {
        this.billRepository = billRepository;
        this.userService = userService;
    }

    public Bill addBill(Bill bill){
        bill.setBillId(bill.getBillId());
        bill.setPrice(bill.getPrice());
        bill.setUser(bill.getUser());
        bill.setIsPaid(false);
        billRepository.save(bill);
        return bill;
    }

    public Bill findBill(Long billId){
        billRepository.findById(billId);

        return null;
    }
    public List<Bill> getAllBill(){
        return billRepository.findAll();
    }
}
