package com.neu.movie_recommend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@MapperScan("com.neu.movie_recommend.dao")
public class MovieRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRecommendApplication.class, args);
    }

}
