package cn.com.busi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@ServletComponentScan
@MapperScan({"cn.com.busi.mapper"})
public class TransportationTechnologyServiceCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportationTechnologyServiceCenterApplication.class, args);
    }

}
