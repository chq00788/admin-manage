package com.chq.project.admin;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动文件
 *
 * @author CHQ
 */
@SpringBootApplication
@EnableSwagger2Doc
public class AdminManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminManageApplication.class, args);
    }

}
