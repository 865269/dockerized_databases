package com.matthew.dockerized_databases.item.repo;

import com.matthew.dockerized_databases.item.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAll();
}
