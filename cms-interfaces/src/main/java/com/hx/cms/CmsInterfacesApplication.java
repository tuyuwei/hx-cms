package com.hx.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author: tywei
 * @create: 2022-04-09 6:19 下午
 **/
@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.hx.cms"})
public class CmsInterfacesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsInterfacesApplication.class, args);
    }
}
