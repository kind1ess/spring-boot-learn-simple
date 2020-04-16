package com.kind1ess.springboot.service;


import com.kind1ess.springboot.entity.Book;
import com.kind1ess.springboot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "book")
public class BookService {

    @Autowired
    BookMapper bookMapper;

    @Cacheable()
    public List findAll(){
        return bookMapper.findAll();
    }
}
