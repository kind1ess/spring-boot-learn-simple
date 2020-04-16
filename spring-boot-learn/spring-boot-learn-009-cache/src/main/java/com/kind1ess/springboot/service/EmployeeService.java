package com.kind1ess.springboot.service;

import com.kind1ess.springboot.entity.Employee;
import com.kind1ess.springboot.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "emp")//设置缓存的公共属性
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 将方法运行结果进行缓存，以后再要相同的数据直接从缓存中去取，不用调方法
     * CacheManager管理多个Cache组件，对缓存真正的CRUD操作在cache组件中，每一个缓存组件有自己一个唯一的名字
     * 几个属性：
     *      cacheName/value:指定缓存的名字
     *      key：缓存数据使用的key；默认是使用方法参数的值  1-方法的返回值
     *              编写SpEL表达式:#id参数id的值 #a0 #p0 #root.args[0]
     *      keyGenerator:key的生成器；可以自己指定key的生成器的组件id
     *          key/keyGenerator二选一
     *      cacheManager：指定缓存管理器
     *      condition：指定符合条件的情况下才缓存
     *      unless:否定缓存，当unless的条件为true就不缓存；可以获取到结果进行判断
     *      sync：是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(/*cacheNames = "emp",*/key = "#id"/*,keyGenerator = "myKeyGenerator"*/,condition = "#id>0",unless = "#result == null")
    public Employee getEmp(Integer id){
        logger.info("查询"+id+"号员工");
        return employeeMapper.getEmployeeById(id);
    }

    /**
     * CachePut注解，既调用方法，有更新缓存数据
     * 修改了数据库某个数据，同时更新缓存
     * 调用时机和CacheAble不一样，先直接调用方法，然后将目标方法的结果缓存起来
     * 注意，如果要更新之前存入的缓存的数据，需要指定key的值
     */
    @CachePut(/*cacheNames = "emp",*/ key = "#employee.id")
    public Employee updateEmp(Employee employee){
        logger.info("更新员工信息："+employee.toString());
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * CacheEvict缓存清除
     * 注意，如果要删除之前存入的缓存的数据，需要指定key的值
     * 属性：allEntries：
     *      是否删除该缓存下所有数据，默认是false
     *      beforeInvocation：是否在方法执行之前执行，用途，如果为false当方法执行出错的时候，缓存就不会清除，如果为true就还是会清除
     */
    @CacheEvict(/*cacheNames = "emp",*/key = "#id")
    public void deleteEmp(Integer id){
        logger.info("deleteEmp:"+id);
//        employeeMapper.deleteEmployee(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(/*cacheNames = "emp",*/key = "#lastName")
            },
            put = {
                    @CachePut(/*cacheNames = "emp",*/key = "#result.id"),//result代表方法返回的结果
                    @CachePut(/*cacheNames = "emp",*/key = "#result.email"),
            }

    )
    public Employee getEmpByLastName(String lastName){
        Employee employee = employeeMapper.getEmployeeByLastName(lastName);
        return employee;
    }
}
