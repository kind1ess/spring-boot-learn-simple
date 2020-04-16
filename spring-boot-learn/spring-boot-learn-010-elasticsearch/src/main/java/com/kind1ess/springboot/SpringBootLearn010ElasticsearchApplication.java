package com.kind1ess.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * springboot默认支持两种技术和ES交互
 * 1、jest（默认不生效）
 *      需要导入es的工具包
 * 2、SpringData ElasticSearch
 *      1）、Client 节点信息clusterNodes
 *      2）、ElasticsearchTemplate操作es
 *      3）、编写一个ElasticsearchRepository的子接口来操作数ES
 */
@SpringBootApplication
public class SpringBootLearn010ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearn010ElasticsearchApplication.class, args);
    }

}
