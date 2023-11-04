package com.bytewave.apiversionspringbootstarter.version.controller;

import com.bytewave.apiversionspringbootstarter.version.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    @ApiVersion("1")
    public String list1() {
        return "list1";
    }

    @GetMapping("/list")
    @ApiVersion("1.1")
    public String list2() {
        return "list2";
    }

}
