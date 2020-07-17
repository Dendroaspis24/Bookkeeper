package com.dhh.bookkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BookkeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeeperApplication.class, args);
        System.out.println("==========================启动完毕==============================");
    }

}
