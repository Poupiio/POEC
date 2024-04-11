package com.example.ExempleAPIBDD.Model.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public Long id;
	
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private UserEntity sender;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private UserEntity receiver;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
