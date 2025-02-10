package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


//✅ This controller exposes a GET endpoint at http://localhost:8080/api/hello which returns "Hello from Netty Server!".
//✅ It returns a Mono<String>, which is the reactive version of a String response.
@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Hello from Netty Server!");
    }

}
