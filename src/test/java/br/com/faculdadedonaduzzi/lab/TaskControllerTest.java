package br.com.faculdadedonaduzzi.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllTasks() throws Exception {
        // O ERRO INTENCIONAL ESTÁ AQUI: Chamando "/tarefa" em vez de "/tarefas"
        ResponseEntity<String> response = restTemplate.getForEntity("/tarefa", String.class);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }
}