package com.kind1ess;

import com.kind1ess.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootLearn003HelloApplicationTests {

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Autowired
    private ApplicationContext ioc;

    @Test
    void testHelloService(){
        System.out.println(ioc.containsBean("helloService"));
    }
}
