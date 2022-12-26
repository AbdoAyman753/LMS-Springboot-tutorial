package com.springboot.demo.controller;

import com.springboot.demo.entity.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/hello")
    public Greeting helloWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(0,"Hello "+name+"!");
    }
}
