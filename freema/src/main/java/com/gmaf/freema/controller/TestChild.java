package com.gmaf.freema.controller;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class TestChild extends TestImp {

    public String bb()
    {
        System.out.println("child bb");

        return null;
    }
}
