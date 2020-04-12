package com.kind1ess.springboot.repository;

import com.kind1ess.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository的两个泛型，第一个是我们要操作的实体类，第二个是实体类的主键类型
 * 不用加@Repository注解，因为JpaRepository已经自动配置到容器里了
 */
public interface UserRepository extends JpaRepository<User,Integer> {


}
