package com.practicalexercises.PathVariable;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping
    public String in() {
        return "Hello World ";
    }
//    @GetMapping("/{nameWelcome}")
//    public String sayHello(@PathVariable String nameWelcome) {
//        return "Hello World " + nameWelcome + "!!";
//    }
//
//    @GetMapping("/{nameWelcome}/{age}")
//    public String sayHelloWithAge(@PathVariable String nameWelcome, @PathVariable int age) {
//        return "Hello World " + nameWelcome + " " + age + " years old";
//    }
//
//    @GetMapping("/{nameWelcome}/{age}/{profession}")
//    public String sayHelloWithDetails(@PathVariable String nameWelcome, @PathVariable int age, @PathVariable String profession) {
//        return "Hello World " + nameWelcome + " " + age + " years old, a " + profession;
//    }

        @GetMapping("/name")
    public String sayHello(@RequestParam String nameWelcome) {
        return "Hello World " + nameWelcome + "!!";
    }

    @GetMapping("/age")
    public String sayHelloWithAge(@RequestParam String nameWelcome,
                                  @RequestParam int age) {
        return "Hello World " + nameWelcome + " " + age + " years old";
    }

    @GetMapping("/profession")
    public String sayHelloWithDetails(@RequestParam String nameWelcome,
                                      @RequestParam int age, @RequestParam String profession) {
        return "Hello World " + nameWelcome + " " + age + " years old, a " + profession;
    }


}
