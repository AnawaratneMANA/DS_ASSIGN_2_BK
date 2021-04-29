package com.testing.demo.Repository;

import com.testing.demo.Model.CreditCardPayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCardPayment , String> {

}
