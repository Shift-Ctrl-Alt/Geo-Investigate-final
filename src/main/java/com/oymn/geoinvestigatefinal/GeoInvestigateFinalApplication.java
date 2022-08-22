package com.oymn.geoinvestigatefinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class GeoInvestigateFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoInvestigateFinalApplication.class, args);
    }

}
