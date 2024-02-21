package com.adjoda.photoapp.api.users.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final Environment environment;

    @GetMapping("/status/check")
    public String status() {
        return "working on port: " + environment.getProperty("local.server.port");
    }
}
