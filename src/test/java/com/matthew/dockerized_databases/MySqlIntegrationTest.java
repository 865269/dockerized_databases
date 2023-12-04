package com.matthew.dockerized_databases;

import com.matthew.dockerized_databases.item.domain.Item;
import com.matthew.dockerized_databases.item.repo.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Testcontainers(disabledWithoutDocker = true)
public class MySqlIntegrationTest {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:latest")
            .withInitScript("schema-mysql.sql");

    @LocalServerPort
    int port;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RestTemplateBuilder builder;

    @Test
    void testGetItems() {
        List<Item> items = List.of(
                new Item(null, "Keyboard"),
                new Item(null, "Mouse")
        );

        itemRepository.saveAll(items);

        RestTemplate template = builder.rootUri("http://localhost:" + port).build();
        ResponseEntity<List<Item>> result = template.exchange(RequestEntity.get("/item/all").build(), new ParameterizedTypeReference<>() {});
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).containsAll(items);
    }
}