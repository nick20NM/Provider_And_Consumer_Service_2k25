package com.alpha.www.MicroserviceB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alpha.www.MicroserviceB.client.HelloFeignClient;

@RestController
@RequestMapping("/call")
public class TestController {

	private final String serviceUrl = "http://localhost:8081/hello";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HelloFeignClient feignClient;
	
	// 1️⃣ RestTemplate
	@GetMapping("/resttemplate")
	public String callUsingRestTemplate() {
		return restTemplate.getForObject(serviceUrl, String.class);
	}
	
	// 2️⃣ FeignClient
	@GetMapping("/feign")
	public String callUsingFeign() {
		return feignClient.sayHello();
	}
}
