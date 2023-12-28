package com.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "products")
public class Product {

    @Id
    private Long prodId;
    private String name;
    private Double price;
    private String desc;
}
