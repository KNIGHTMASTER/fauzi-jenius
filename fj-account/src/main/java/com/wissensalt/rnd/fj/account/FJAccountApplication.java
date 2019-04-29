package com.wissensalt.rnd.fj.account;

import com.wissensalt.rnd.fj.util.apilogger.LoggableDispatcherServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@ComponentScan(basePackages = {
        "com.wissensalt.rnd.fj.util.apilogger",
        "com.wissensalt.rnd.fj.util.feign",
        "com.wissensalt.rnd.fj.account.endpoint",
        "com.wissensalt.rnd.fj.account.mapper",
        "com.wissensalt.rnd.fj.account.service",
        "com.wissensalt.rnd.fj.account.config"
}, lazyInit = true)
@EnableResourceServer
@EntityScan(basePackages = {"com.wissensalt.rnd.fj.shared.data.model"})
@EnableRedisRepositories
@EnableMongoRepositories(basePackages = {"com.wissensalt.rnd.fj.shared.dao"})
@EnableMongoAuditing
@SpringBootApplication
public class FJAccountApplication {

    public static void main(String [] args) {
        SpringApplication.run(FJAccountApplication.class);
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new LoggableDispatcherServlet();
    }
}
