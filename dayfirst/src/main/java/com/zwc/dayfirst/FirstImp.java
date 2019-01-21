package com.zwc.dayfirst;

import org.springframework.stereotype.Service;

@Service
public class FirstImp implements FirstInterface {
    @Override
    public String first() {
        return "this is a good";
    }
}
