package com.rcloud.spellweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.rcloud.spelldao.dao"})
//扫描注解类
@ComponentScan({"com.rcloud"})
public class SpellWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpellWebApplication.class, args);
    }

}