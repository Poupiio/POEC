package com.example.firstAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstAPI.Service.InfoService;

@RestController
public class apiController {
	InfoService info;
	
	@Autowired
	public apiController(InfoService info) {
		this.info = info;
	}
	
	@GetMapping("/sports")
	public List<String> getAll() {
		return info.getAllSports();
	}
	
	@GetMapping("/elise")
	public List<String> getMe() {
		return info.getMe();
	}
}
