package com.matthew.dockerized_databases;

import com.matthew.dockerized_databases.item.domain.Item;
import com.matthew.dockerized_databases.item.repo.ItemRepository;
import com.matthew.dockerized_databases.user.User;
import com.matthew.dockerized_databases.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ControllerTest {

    private Controller testee;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
        testee = new Controller(itemRepository, userRepository);
    }

    @Test
    void getAllItems() {
        Item item = Item.builder()
                .id(nextLong())
                .name(randomAlphanumeric(10))
                .build();

        when(itemRepository.findAll()).thenReturn(Collections.singletonList(item));

        List<Item> items = testee.getAllItems();

        verify(itemRepository).findAll();
        assertThat(items).contains(item);
    }

    @Test
    void getAllUsers() {
        User user = User.builder()
                .id(nextLong())
                .name(randomAlphanumeric(10))
                .build();

        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> users = testee.getAllUsers();

        verify(userRepository).findAll();
        assertThat(users).contains(user);
    }
}