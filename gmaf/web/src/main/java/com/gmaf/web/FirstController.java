package com.gmaf.web;

import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class FirstController {
    @Autowired
    private FirstMapper firstMapper;
    @RequestMapping("/first")
    public Object  first(@RequestBody String id)
    {

        Customer customer = new Customer();

        System.out.println(customer.toString());

        customer = firstMapper.selectFirst("123");  //查出结果为 id:123,name:123

        customer.setName("456");


        Customer customer2 = new Customer();
        customer2 = firstMapper.selectFirst("123");

        return null;
    }
}
