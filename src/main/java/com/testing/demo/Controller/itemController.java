package com.testing.demo.Controller;

import com.testing.demo.Model.Item;
import com.testing.demo.Repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    //Add item
    @PostMapping("/item")
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        try{
            item.setCreatedAt(new Date(System.currentTimeMillis()));
            itemRepo.save(item);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Single item
    @GetMapping("/item/{id}")
    public ResponseEntity<?> getSingleItem(@PathVariable("id") String id){
        Optional<Item> itemOptional = itemRepo.findById(id);
        if(itemOptional.isPresent()){
            return new ResponseEntity<>(itemOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Item not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }

    //Update item
    @PutMapping("/item/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Item item){
        Optional<Item> itemOptional = itemRepo.findById(id);
        if(itemOptional.isPresent()){
            Item itemToSave = itemOptional.get();
            itemToSave.setTitle(item.getTitle() != null ? item.getTitle() : itemToSave.getTitle());
            itemToSave.setPrice(item.getPrice() != null ? item.getPrice() : itemToSave.getPrice());
            itemToSave.setDescription(item.getDescription() != null ? item.getDescription() : itemToSave.getDescription());
            itemToSave.setImage(item.getImage() != null ? item.getImage() : itemToSave.getImage());
            itemToSave.setUpdateAt(new Date(System.currentTimeMillis()));
            itemRepo.save(itemToSave);
            return new ResponseEntity<>(itemToSave, HttpStatus.OK);

        }else{
            return new ResponseEntity<>("Item not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }


}
