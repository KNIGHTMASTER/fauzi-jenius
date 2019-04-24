package com.wissensalt.rnd.fj.sec.oauth2.endpoint.impl;

import com.wissensalt.rnd.fj.util.apilogger.RequestLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 7/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping("/secured")
public class SecureEndPoint {

    @RequestLogger(name = "oauth2|secured-hello")
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Secure Hello!";
    }

}