package com.wissensalt.rnd.fj.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@ComponentScan(basePackages = {
        "com.wissensalt.rnd.fj.util.apilogger",
        "com.wissensalt.rnd.fj.util.feign",
        "com.wissensalt.rnd.fj.sec.oauth2.endpoint",
        "com.wissensalt.rnd.fj.sec.oauth2.mapper",
        "com.wissensalt.rnd.fj.sec.oauth2.service",
        "com.wissensalt.rnd.fj.sec.oauth2.config"
}, lazyInit = true)
@EntityScan(basePackages = {"com.wissensalt.rnd.fj.shared.data.model"})
@EnableMongoRepositories(basePackages = {"com.wissensalt.rnd.fj.shared.dao"})
@EnableMongoAuditing
@SpringBootApplication
public class FJAccountApplication {

    public static void main(String [] args) {
        SpringApplication.run(FJAccountApplication.class);
    }
}
