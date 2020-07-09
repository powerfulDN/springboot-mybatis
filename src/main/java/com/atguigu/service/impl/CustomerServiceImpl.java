package com.atguigu.service.impl;

import com.atguigu.dao.CustomerDao;
import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.KdcErrException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public List<Customer> findAll() {
        // redis d的key
        String key =  "allcustomer";
        // 先查询 redis 中是否有数据，如果有直接返回 redis的数据
        List<Customer> customers = (List<Customer>) redisTemplate.boundValueOps(key).get();

        if (customers != null){
            System.out.println("从redis 缓存中获取的数据为 = " + customers);
            return customers;
        }
        // 如果没有，从数据库 查询
        customers = customerDao.findAll();

        // 将数据库数据存入到 redis 中
        if (customers.size()> 0 && customers != null){
            System.out.println("从数据库中获取数据存放到Redis缓存="+customers);
            redisTemplate.boundValueOps(key).set(customers);
        }
        return customers;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.getOne(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteById(id);
    }
}
