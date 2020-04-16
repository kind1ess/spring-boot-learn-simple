package com.kind1ess.springboot.entity;


import io.searchbox.annotations.JestId;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;
}
