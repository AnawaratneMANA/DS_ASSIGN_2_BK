package com.testing.demo.Repository;

import com.testing.demo.Model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepository extends MongoRepository<Item, String> {

}
