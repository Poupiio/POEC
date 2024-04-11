package com.example.firstAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InfoService {
	
	public List<String> getAllSports() {
		return List.of("Danse", "MMA", "Musculation");
	}
	
	public List<String> getMe() {
		return List.of("Elise", "MAAÏZA");
	}
	
}
