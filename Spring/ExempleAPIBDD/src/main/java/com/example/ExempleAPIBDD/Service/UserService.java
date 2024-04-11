package com.example.ExempleAPIBDD.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ExempleAPIBDD.Model.Entity.UserEntity;
import com.example.ExempleAPIBDD.Model.Repository.UserRepository;

@Service
public class UserService {
	
	public UserRepository repo;
	
	public UserService(UserRepository dependance)
	{
		this.repo = dependance;
	}

	public Iterable<UserEntity> getAll()
	{
		return this.repo.findAll();
	}
	
	public Optional<UserEntity> getById(Long id)
	{
		return this.repo.findById(id);
	}
	
	public UserEntity UpdateById(Long id, UserEntity data)
	{
		UserEntity user = this.repo.findById(id).get();
		
		user.setCredit(data.getCredit());
		user.setName(data.getName());
		user.setEmail(data.getEmail());
		
		return this.repo.save(user);
	}
	
	
	
	public Optional<UserEntity> FindUser(UserEntity data)
	{
		List<UserEntity> listUser = (List<UserEntity>) this.getAll();
		
		
		return listUser.stream()
                .filter((user) -> user.getName().equals(data.getName()))
                .findFirst();
			}
	
	
	public UserEntity AddUser(UserEntity data)
	{
		return this.repo.save(data);
	}
	
	public void DeleteById(Long id)
	{
		this.repo.deleteById(id);
	}
}
