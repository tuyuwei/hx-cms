package com.hx.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: tywei
 * @create: 2022-04-09 8:03 下午
 **/
@SpringBootApplication(scanBasePackages = {"com.hx.cms"})
public class CmsAdminInterfacesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsAdminInterfacesApplication.class, args);
    }

}
