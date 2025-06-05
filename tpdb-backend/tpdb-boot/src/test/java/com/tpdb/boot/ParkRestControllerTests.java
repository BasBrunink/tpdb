package com.tpdb.boot;

import com.tpdb.domain.model.Park;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkRestControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAllParksShouldReturn200() {
        var response = restTemplate.getForEntity("http://localhost:" + port + "/parks", Park[].class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
