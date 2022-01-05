package portfolio.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // 스프링부트 사용 자동주입
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }
}
