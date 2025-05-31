package com.alpha.www.MicroserviceB.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "MicroserviceA", url = "http://localhost:8081")
public interface HelloFeignClient {

	@GetMapping("/hello")
	String sayHello();
}
