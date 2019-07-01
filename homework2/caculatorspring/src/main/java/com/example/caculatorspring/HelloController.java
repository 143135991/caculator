package com.example.caculatorspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/caculator")
    public String toIndex(){
        return "caculator";
    }
}
