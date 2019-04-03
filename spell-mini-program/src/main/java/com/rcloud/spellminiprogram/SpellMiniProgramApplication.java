package com.rcloud.spellminiprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan({"com.rcloud.spelldao.dao"})
//扫描注解类
@ComponentScan({"com.rcloud"})
@EnableScheduling
public class SpellMiniProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpellMiniProgramApplication.class, args);
    }

}

