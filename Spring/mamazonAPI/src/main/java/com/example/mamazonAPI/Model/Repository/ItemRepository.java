package com.example.mamazonAPI.Model.Repository;

import com.example.mamazonAPI.Model.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {}
