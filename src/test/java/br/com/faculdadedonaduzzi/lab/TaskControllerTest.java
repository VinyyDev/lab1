package br.com.faculdadedonaduzzi.lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void testGetAllTasks() throws Exception {
        // O ERRO INTENCIONAL ESTÁ AQUI: Chamando "/tarefa" em vez de "/tarefas"
        URL url = new URL("http://localhost:" + port + "/tarefas");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        assertThat(status).isEqualTo(200);
    }
}