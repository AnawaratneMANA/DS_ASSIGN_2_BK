package com.testing.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//Created by Salitha
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "CreditCard")
public class CreditCardPayment {
    @Id
    private String id;
    private String userId;
    private String creditCardNumber;
    private String creditCardUser;
    private String Amount;
    private int cvc_Number;

}
