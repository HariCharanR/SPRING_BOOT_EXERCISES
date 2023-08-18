package com.solutions.day1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	
	@GetMapping("/welcome")
	public String showGreeting() {
		return "Welcome";
	}
	
	@GetMapping("/")
	public String disp() {
		String color = myFavColor();
		return "My name is haricharan \n"+ color;
	}
	
	
	public String myFavColor() {
		return "my favorite color is "+ "green";
	}
}
