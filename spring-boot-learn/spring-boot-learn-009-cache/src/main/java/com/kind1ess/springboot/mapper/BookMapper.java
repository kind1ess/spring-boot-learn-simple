package com.kind1ess.springboot.mapper;


import com.kind1ess.springboot.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @Select("select * from book")
    List<Book> findAll();
}
