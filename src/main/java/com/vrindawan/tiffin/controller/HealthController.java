package com.vrindawan.tiffin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("status")
    public String getStatus(){
        return "OK";
    }
}
