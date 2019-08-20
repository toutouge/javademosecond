package learn.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by toutou on 2019/7
 */
@SpringBootApplication
@ComponentScan(basePackages = {"learn.*" })
@MapperScan(basePackages = {"learn.persist"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}