package com.matthew.dockerized_databases.item;

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

class ItemControllerTest {

    private ItemController testee;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
        testee = new ItemController(itemRepository);
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
}