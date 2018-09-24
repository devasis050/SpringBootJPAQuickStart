package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("hello")
public class HelloController {

	@GetMapping("hello/{name}")
	public String helloBoy(@PathVariable String name)
	{
		return "Hello " + name;
	}
}
