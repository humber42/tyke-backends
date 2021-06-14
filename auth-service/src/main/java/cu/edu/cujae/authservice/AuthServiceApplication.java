package cu.edu.cujae.authservice;

import cu.edu.cujae.authservice.filters.FilterIPZuul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableZuulProxy //act as Zuul proxy
@EnableEurekaServer//for making this application as eureka server
@EnableFeignClients
@SpringBootApplication
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

   

    @Bean
    public FilterIPZuul filterIPZuul() {
        return new FilterIPZuul();
    }
}

