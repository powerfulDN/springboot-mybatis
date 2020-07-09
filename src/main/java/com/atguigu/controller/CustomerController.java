package com.atguigu.controller;


import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 相当于 @RequestMapping 和ResponseBody
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/findAll")
    public List<Customer> findAll(){

        return customerService.findAll();
    }

    @RequestMapping(value = "/findCustomerById/{id}")
    public Customer findCustomerById(@PathVariable("id") Integer id){
        return customerService.findCustomerById(id) ;
    }

    @RequestMapping(name = "/saveCustomer")
    public void saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
    }

    @RequestMapping("/updateCustomer")
    public void updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
    }
}
