package com.testing.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class User {

    @Id
    private String id;

    private String userName;
    private String email;
    private String passWord1;
    private String passWord2;
    private String userType;

    //Extra methods comes here.

}
