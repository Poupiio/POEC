package com.example.firstAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SportService {
	
	private List<String> data = new ArrayList<String>();
	
	public List<String> add(String newData)
	{
		this.data.add(newData);
		return this.data;
	}
	
	public List<String> getData()
	{
		return this.data;
	}
	
	public String UpdateData(Integer index, String data)
	{
		this.data.set(index, data);
		return data;
	}
	
	public String DeleteData(Integer index)
	{
		this.data.remove(index);
		return "";
	}

}
