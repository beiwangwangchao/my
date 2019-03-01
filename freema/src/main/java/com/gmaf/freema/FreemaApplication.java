package com.gmaf.freema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.gmaf.freema.controller","com.gmaf.freema.utils"})
@SpringBootApplication

public class FreemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreemaApplication.class, args);
    }

}

