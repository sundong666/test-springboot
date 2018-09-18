package com.asiainfo.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.asiainfo.springboot.mapper")// 扫描mapper接口
public class TestSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootApplication.class, args);
	}
}
