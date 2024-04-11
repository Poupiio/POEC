package com.example.mvc.Model.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.Model.Entity.Emprunt;

@Repository
public interface EmpruntRepository extends CrudRepository<Emprunt, Long> {}