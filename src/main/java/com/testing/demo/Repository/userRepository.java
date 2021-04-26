package com.testing.demo.Repository;

import com.testing.demo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<User, Integer> {
    //Complex Queries comes here.
}
