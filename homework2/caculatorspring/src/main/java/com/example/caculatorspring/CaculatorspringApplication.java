package com.example.caculatorspring;

import com.example.caculatorspring.endpoint.MyEndPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CaculatorspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaculatorspringApplication.class, args);
    }

    /*@Configuration
    static class MtEndPointConfiguration {
        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnEnabledEndpoint
        public MyEndPoint myendpoint() {
            return new MyEndPoint();
        }
    }*/

}
