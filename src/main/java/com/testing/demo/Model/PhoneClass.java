package com.testing.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "PhoneClassTable")
public class PhoneClass {

    @Id
    private String id;
    private String userId;
    private String Phone_Number;
    private Double Amounts;
    private int Pin_Number;
}
