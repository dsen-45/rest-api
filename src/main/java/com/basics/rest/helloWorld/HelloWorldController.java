package com.basics.rest.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String getHelloWorld() {
		return "HELLO WORLD";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("HELLO WORLD");
	}

	@GetMapping(path = "/hello-world-bean/path/{id}")
	public HelloWorldBean getHelloWorldPath(@PathVariable String id) {
		return new HelloWorldBean(String.format("HELLO WORLD, %s" , id));
	}

}
