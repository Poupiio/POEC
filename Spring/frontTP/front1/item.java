package com.example.CorrectionApi.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping()
	public String user() {
		return "user";
	}

	@GetMapping("/{id}")
	public String user(@PathVariable int id) {
		return "user" + id;
	}

	@PostMapping()
	public User user(@RequestBody User user) {
		return ;
	}

	@PutMapping("/{id}")
	public String user(@PathVariable int id) {
		return "user" + id;
	}

}
