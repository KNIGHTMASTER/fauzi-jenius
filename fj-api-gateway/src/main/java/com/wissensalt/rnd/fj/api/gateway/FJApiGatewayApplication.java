package com.wissensalt.rnd.fj.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class FJApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FJApiGatewayApplication.class, args);
    }
}
