package com.wissensalt.rnd.fj.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@EnableEurekaServer
@SpringBootApplication
public class FJServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FJServiceRegistryApplication.class, args);
    }
}
