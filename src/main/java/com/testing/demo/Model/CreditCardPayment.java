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
@Document(collection = "CreditCardTable")
public class CreditCardPayment {
    @Id
    private String id;
    private String userId;
    private String CreditCardNumber;
    private String CreditCardUser;
    private Double Amount;
    private int CVC_Number;

}
