package app.models.controllers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class HeartbeatControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testRandomHeartbeat_should_return_Status200() throws Exception {
        mvc.perform(get("/heartbeat"))
                .andExpect(status().isOk());
    }

}
