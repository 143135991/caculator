package com.cloud.provider.controller;

import com.cloud.provider.entity.caculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class caculatorController {

    @GetMapping("/{tokens}")
    public String toIndex(@PathVariable String tokens){
        caculator Caculator = new caculator();
        return Caculator.putin(tokens);
    }
}
