package com.solutions.day2.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameDisplayer {
		
		@Value("${name}")
		private String name;
		
		@GetMapping("/")
		public String disp() {
			return name;
		}
		
}
