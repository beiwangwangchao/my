package com.gmaf.freema.controller;

import org.springframework.stereotype.Component;


public class TestImp implements Test{
    @Override
    public String aa() {
        System.out.println("parent aa");
        bb();
        return null;
    }

    @Override
    public String bb() {
        System.out.println("parent bb");
        return null;
    }
}
