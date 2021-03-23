package com.lsh.springboothotkey;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootHotkeyApplication {
    private static final Logger logger = Logger.getLogger(SpringbootHotkeyApplication.class);
    public static void main(String[] args) {
        logger.debug("这是debug信息");
        SpringApplication.run(SpringbootHotkeyApplication.class, args);
    }

}
