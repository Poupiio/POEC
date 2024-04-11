package com.example.tp5users.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp5users.Model.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}
