package com.neu.shopping_recommend;

import com.neu.shopping_recommend.domain.Commodity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@MapperScan("com.neu.shopping_recommend.dao")
public class ShoppingRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingRecommendApplication.class, args);
    }

}
