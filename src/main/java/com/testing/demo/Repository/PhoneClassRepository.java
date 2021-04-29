package com.testing.demo.Repository;

import com.testing.demo.Model.PhoneClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneClassRepository extends MongoRepository<PhoneClass, String> {

}
