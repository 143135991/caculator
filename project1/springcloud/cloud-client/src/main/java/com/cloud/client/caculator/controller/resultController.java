package com.cloud.client.caculator.controller;

import com.cloud.client.caculator.feign.caculatorFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class resultController {
    @Autowired
    private caculatorFeignClient caculatorFeignClient;
    @GetMapping("/caculator/{tokens}")
    public String themainfunc(@PathVariable String tokens) {
        String result = caculatorFeignClient.getresult(tokens);
        return result;
    }
}
