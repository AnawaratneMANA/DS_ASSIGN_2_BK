package com.testing.demo.Controller;
import com.testing.demo.Model.User;
import com.testing.demo.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Main REST Controller.

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class userController {

    @Autowired
    private userRepository userRepo;
    //Create user Method
    @PostMapping("/user")
    public ResponseEntity createUser(@RequestParam User user){
        try{
            userRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get User Method.

}
