package com.testing.demo.Controller;
import com.testing.demo.Model.Item;
import com.testing.demo.Model.LoginUser;
import com.testing.demo.Model.User;
import com.testing.demo.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//Main REST Controller.

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class userController {

    @Autowired
    private userRepository userRepo;
    //Create user Method
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            userRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get User Method.
    @PostMapping("/validate")
    public ResponseEntity<?> validateUser (@RequestBody LoginUser user){
        String message = "default";
        try {
            User object = userRepo.findUserByUsername(user.getUserName());
            if(object != null) {
                if(object.getPassWord1().contentEquals(user.getPassword())){
                    message = "Valid User";
                } else {
                    message = "Wrong Password";
                }
            } else
            {
                message = "User Not Found";
            }
            return new ResponseEntity<>(message , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.OK);
        }
    }

    //Method to get the user Id
    @PostMapping("/getValdatedUserId")
    public ResponseEntity<?> getValidateUser (@RequestBody LoginUser user){
        String userId = "default";
        try {
            User object = userRepo.findUserByUsername(user.getUserName());
            if(object != null) {
                if(object.getPassWord1().contentEquals(user.getPassword())){
                    userId = object.getId();
                } else {
                    userId = "Error";
                }
            } else
            {
                userId = "Error";
            }
            return new ResponseEntity<>(userId , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.OK);
        }
    }

    @PostMapping("/getValdatedUseremail")
    public ResponseEntity<?> getValidateUserEmail (@RequestBody LoginUser user){
        String email = "default";
        try {
            User object = userRepo.findUserByUsername(user.getUserName());
            if(object != null) {
                if(object.getPassWord1().contentEquals(user.getPassword())){
                    email = object.getEmail();
                } else {
                    email = "Error";
                }
            } else
            {
                email = "Error";
            }
            return new ResponseEntity<>(email , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.OK);
        }
    }
}
