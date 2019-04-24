package com.wissensalt.rnd.fj.sec.oauth2;

import com.wissensalt.rnd.fj.util.apilogger.LoggableDispatcherServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.DispatcherServlet;

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
@EntityScan(basePackages = {"com.wissensalt.rnd.fj.sec.oauth2.data"})
@EnableJpaRepositories(basePackages = {"com.wissensalt.rnd.fj.sec.oauth2.dao"})
@EnableJpaAuditing
@SpringBootApplication
public class FJOAuth2Application {

    public static void main(String [] args) {
        SpringApplication.run(FJOAuth2Application.class);
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new LoggableDispatcherServlet();
    }
}
