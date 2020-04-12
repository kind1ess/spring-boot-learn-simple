package com.kind1ess.springboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity//告诉jpa这是一个实体类（和数据表映射）
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})    //不加这个解析对象转换为json数据时会报错
@Table(name = "tb_user")
public class User {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增
    private Integer id;

    @Column(name = "last_name",length = 50) //这是和数据表对应的一个列，省略默认列名就是属性名
    private String lastName;

    @Column
    private String name;
}
