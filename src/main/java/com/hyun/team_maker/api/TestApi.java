package com.hyun.team_maker.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name;
    }

    @PostMapping("/hello/world")
    public String postHelloWorld() {
        return "[Post] Hello world";
    }

    @PutMapping("/hello/world")
    public String putHelloWorld() {
        return "[Put] Hello world";
    }

    @DeleteMapping("/hello/world")
    public String deleteHelloWorld() {
        return "[Delete] Hello world";
    }

    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ) {
        return "Hello world my name is " + name + " and my age is " + age ;
    }

    @PostMapping("/test/body")
    public String requestBody(@RequestBody TestRequestBody request) {
        System.out.println("request.name : " + request.name);
        System.out.println("request.age : " + request.age);
        return "test RequestBody name : " + request.name + "age : " + request.age;
    }

    public static class TestRequestBody {
        String name;
        Integer age;

        public TestRequestBody() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}
