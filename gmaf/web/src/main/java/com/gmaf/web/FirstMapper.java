package com.gmaf.web;

import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Component
public interface FirstMapper {
    @Options(useCache = false)
    public Customer selectFirst(String Id);
    public void insert(Customer customer);
    public Customer selectSecond(String name);

    public void update(Customer customer);
}
