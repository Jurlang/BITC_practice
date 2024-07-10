package com.mysite.boot01_ajax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Boot01AjaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot01AjaxApplication.class, args);
    }

}
