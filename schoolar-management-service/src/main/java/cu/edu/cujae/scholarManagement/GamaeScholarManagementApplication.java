package cu.edu.cujae.scholarManagement;

import cu.edu.cujae.scholarManagement.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.File;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
@EnableEurekaClient
@EnableFeignClients
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class GamaeScholarManagementApplication {

    public static void main(String... args){
        SpringApplication.run(GamaeScholarManagementApplication.class,args);
    }
}
