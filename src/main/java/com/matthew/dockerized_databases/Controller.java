package com.matthew.dockerized_databases;

import com.matthew.dockerized_databases.item.domain.Item;
import com.matthew.dockerized_databases.item.repo.ItemRepository;
import com.matthew.dockerized_databases.user.domain.User;
import com.matthew.dockerized_databases.user.repo.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final ItemRepository itemRepository;
    private UserRepository userRepository;

    public Controller(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/item/all")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/user/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
