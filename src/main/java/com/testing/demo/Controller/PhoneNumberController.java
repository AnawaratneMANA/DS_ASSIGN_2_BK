package com.testing.demo.Controller;

import com.testing.demo.Model.PhoneClass;
import com.testing.demo.Repository.PhoneClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PhoneNumberController {

    @Autowired
    private PhoneClassRepository phoneClassRepository;

    @PostMapping("/addPhoneDetails")
    public String savePhoneDetail(@RequestBody PhoneClass detail){
        phoneClassRepository.save(detail);
        return "Payment Addition of Payment ID "+detail.getId() + " is done";
    }

    @GetMapping("/displayPhoneDetails")
    public ResponseEntity<?> getAllPhoneDetails() {
        List<PhoneClass> payment = phoneClassRepository.findAll();
        if (payment.size() > 0){
            return new ResponseEntity<List<PhoneClass>>(payment, HttpStatus.OK);
        }
        return new ResponseEntity<>("There's no payment details available", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updatePhoneDetailsById/{id}")
    public ResponseEntity<?> updateByPhoneDetailById(@PathVariable("id") String id, @RequestBody PhoneClass detail){
        Optional<PhoneClass> payment = phoneClassRepository.findById(id);
        if (payment.isPresent()) {
            PhoneClass recentdetails = payment.get();
            recentdetails.setUserId(detail.getUserId() != null ? detail.getUserId() : recentdetails.getUserId());
            recentdetails.setPhone_Number(detail.getPhone_Number() != null ? detail.getPhone_Number() : recentdetails.getPhone_Number());
            recentdetails.setAmount(detail.getAmount() != null ? detail.getAmount() : recentdetails.getAmount());
            recentdetails.setPin_Number(detail.getPin_Number() != 0 ? detail.getPin_Number() : recentdetails.getPin_Number());
            phoneClassRepository.save(recentdetails);
            return new ResponseEntity<>(recentdetails, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("payment id is  not Found "+id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getSinglePhoneDetail/{id}")
    public ResponseEntity<?> getSinglePhoneDetail(@PathVariable("id") String id){
        Optional<PhoneClass> payment = phoneClassRepository.findById(id);
        if (payment.isPresent()) {
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Phone Detail is  not Found "+id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletePhoneDetail/{id}")
    public String deletePhoneCardDetail(@PathVariable String id){
        phoneClassRepository.deleteById(id);
        return "Deleted paymentID: "+id;
    }
   // PhoneClassRepository
            //PhoneClass
}
