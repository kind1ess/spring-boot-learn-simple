package com.kind1ess.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer goodsId;
    private String bookName;
    private String introduce;
    private String publisher;
    private String publishDate;
    private Double nowPrice;
}
