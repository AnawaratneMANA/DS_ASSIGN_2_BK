package com.testing.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "item")
public class Item {

    @Id
    private String id;
    private String title;
    private String price;
    private String description;
    private String image;

    private Date createdAt;
    private Date updateAt;

}
