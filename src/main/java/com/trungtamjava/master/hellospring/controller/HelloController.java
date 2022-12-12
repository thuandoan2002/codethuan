package com.trungtamjava.master.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
//@RestController
public class HelloController {

    //localhost:8080/api/hello-spring
    @GetMapping("/hello-spring")
    public  String hello(Model model) {
        model.addAttribute("msg", "Helle Spring Framework");
        return  "hi";  //view
    }
}
