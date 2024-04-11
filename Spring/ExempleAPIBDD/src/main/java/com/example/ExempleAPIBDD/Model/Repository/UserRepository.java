package com.example.ExempleAPIBDD.Model.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExempleAPIBDD.Model.Entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	// Méthodes nécessaires au fonctionnement de mon back
}
