package com.kind1ess.springboot.controller;

import com.kind1ess.springboot.entity.Book;
import com.kind1ess.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public List findAll(){
        return bookService.findAll();
    }
}
