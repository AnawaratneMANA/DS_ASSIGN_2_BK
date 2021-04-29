package com.testing.demo.Controller;

import com.testing.demo.Model.CreditCardPayment;
import com.testing.demo.Repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CreditCardController {
    @Autowired
    private  CreditCardRepository creditCardRepository;

    @PostMapping("/addCreditCardDetails")
    public String saveCreditCardDetail(@RequestBody CreditCardPayment detail){
        creditCardRepository.save(detail);
        return "Payment Addition of Payment ID "+detail.getId() + " is done";
    }

    @GetMapping("/displayCreditCardDetails")
    public ResponseEntity<?> getAllCreditCardDetails() {
        List<CreditCardPayment> payment = creditCardRepository.findAll();
        if (payment.size() > 0){
            return new ResponseEntity<List<CreditCardPayment>>(payment, HttpStatus.OK);
        }
        return new ResponseEntity<>("There's no payment details available", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateCreditCardDetailsById/{id}")
    public ResponseEntity<?> updateByCreditCardDetailId(@PathVariable("id") String id, @RequestBody CreditCardPayment detail){
        Optional<CreditCardPayment> payment = creditCardRepository.findById(id);
        if (payment.isPresent()) {
            CreditCardPayment recentdetails = payment.get();
            recentdetails.setUserId(detail.getUserId() != null ? detail.getUserId() : recentdetails.getUserId());
            recentdetails.setCreditCardUser(detail.getCreditCardUser() != null ? detail.getCreditCardUser() : recentdetails.getCreditCardNumber());
            recentdetails.setCreditCardNumber(detail.getCreditCardNumber() != null ? detail.getCreditCardNumber() : recentdetails.getCreditCardNumber());
            recentdetails.setAmount(detail.getAmount() != null ? detail.getAmount() : recentdetails.getAmount());
            recentdetails.setCVC_Number(detail.getCVC_Number() != 0 ? detail.getCVC_Number() : recentdetails.getCVC_Number());
            creditCardRepository.save(recentdetails);
            return new ResponseEntity<>(recentdetails, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("payment id is  not Found "+id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getSingleCreditCardDetail/{id}")
    public ResponseEntity<?> getSingleCreditCardDetail(@PathVariable("id") String id){
        Optional<CreditCardPayment> payment = creditCardRepository.findById(id);
        if (payment.isPresent()) {
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Credit Card Detail is  not Found "+id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCreditCardDetail/{id}")
    public String deleteCreditCardDetail(@PathVariable String id){
        creditCardRepository.deleteById(id);
        return "Deleted paymentID: "+id;
    }



}
