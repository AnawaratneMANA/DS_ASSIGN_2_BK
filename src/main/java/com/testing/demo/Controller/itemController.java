package com.testing.demo.Controller;

import com.testing.demo.Model.Item;
import com.testing.demo.Repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class itemController {

    @Autowired
    private itemRepository itemRepo;

    @GetMapping("/item")
    public ResponseEntity<?> getAllItems(){
        List<Item> items = itemRepo.findAll();
        if(items.size() > 0){
            return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No items available", HttpStatus.NOT_FOUND);
        }
    }
}
