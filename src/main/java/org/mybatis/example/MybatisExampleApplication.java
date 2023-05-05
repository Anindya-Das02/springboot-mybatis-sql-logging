package org.mybatis.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.mybatis.example.mapper")
public class MybatisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisExampleApplication.class, args);
	}

}
