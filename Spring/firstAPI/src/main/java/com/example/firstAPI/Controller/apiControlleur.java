package com.example.firstAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstAPI.Service.SportService;

@RestController
public class apiControlleur {
	
	@Autowired
	private SportService sport;
	
	@GetMapping("/sports")
	public List<String> getAllSports()
	{
		return sport.getData();
	}
	
	@PostMapping("/sports")
	public List<String> postAllSports(@RequestBody String body)
	{
		return sport.add(body);
	}
	
	@PutMapping("/sports/{id}")
	public String getAllSpor(@RequestBody String body, @PathVariable Integer id)
	{
		return sport.UpdateData(id, body);
	}
	
	@DeleteMapping("/sports/{id}")
	public String getAllSp(@PathVariable Integer id)
	{
		return sport.DeleteData(id);
	}

}
