package com.bootcamp.evam_java.services;

import com.bootcamp.evam_java.entity.Bill;
import com.bootcamp.evam_java.entity.PaymentReq;
import com.bootcamp.evam_java.entity.PaymentRes;
import com.bootcamp.evam_java.entity.User;
import com.bootcamp.evam_java.repositories.BillRepository;
import com.bootcamp.evam_java.repositories.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PaymentService {
    private final UserRepository userRepository;
    private final BillService billService;
    private final BillRepository billRepository;
    private final UserService userService;

    public PaymentService(UserRepository userRepository, BillService billService, BillRepository billRepository, UserService userService) {
        this.userRepository = userRepository;
        this.billService = billService;
        this.billRepository = billRepository;
        this.userService = userService;
    }

    public String makePayment(Long userId ,Long billId){
        /*PaymentReq payment = memberAccountService.findOneAccount(memberCode);
         */
        Bill bill = billService.findBill(billId);
        User user = userService.findUser(userId);


        if (user.getWallet() >= bill.getPrice()) {
            Double wallet = user.getWallet() - bill.getPrice();
            user.setWallet(wallet);
            bill.setIsPaid(true);
        } else {
            throw new NullPointerException();
        }

        return "ok";
    }

    public List<PaymentReq> payment2(List<PaymentRes> pays){
        List<PaymentReq> paymentReqs =new ArrayList<>();

        pays.forEach(wallets ->{

            Double result ;
            Optional<Bill> bill = billRepository.findById(wallets.getBillId());
            Optional<User> user = userRepository.findById(wallets.getUserId());
            result = (user.get().getWallet()-bill.get().getPrice());
            paymentReqs.add(new PaymentReq(wallets.getUserId(), wallets.getBillId(), result));
            bill.get().setIsPaid(true);
            user.get().setWallet(result);
        });
        return paymentReqs;
    }


}