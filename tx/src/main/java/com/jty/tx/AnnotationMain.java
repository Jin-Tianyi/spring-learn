package com.jty.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author :jty
 * @date :20-10-30
 */
@SpringBootApplication
public class AnnotationMain implements CommandLineRunner {

    @Autowired
    OrderService orderService;
    public static void main(String[] args) {
        new SpringApplicationBuilder(AnnotationMain.class).web(WebApplicationType.NONE).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.doOrder();
    }
}
