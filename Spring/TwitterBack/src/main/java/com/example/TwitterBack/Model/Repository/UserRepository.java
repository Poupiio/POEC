package com.example.TwitterBack.Model.Repository;

import com.example.TwitterBack.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Ne pas oublier de mettre le MÊME NOM QUE L'ATTRIBUT
    Optional<User> findByUsername(String username);
}
