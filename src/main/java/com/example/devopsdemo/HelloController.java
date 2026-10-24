package com.example.devopsdemo;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
public class HelloController {
 @GetMapping("/hello") public String hello() {return "DevOps demo application is running!";}
 @GetMapping("/health") public Map<String,String> health() {return Map.of("status","UP");}
}
