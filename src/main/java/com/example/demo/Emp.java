package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Emp {
	
@RequestMapping("dummy")

 String dummy() {
	 return "<h1>hlooo dummy </h1>";
	 
 }

@RequestMapping("demo")	
String demo() {
 return "<h1>Demo app </h1>";
 
}
}
