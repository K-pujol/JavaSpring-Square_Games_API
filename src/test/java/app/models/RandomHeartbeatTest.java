package app.models;

import app.interfaces.HeartbeatSensor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@AutoConfigureMockMvc
public class RandomHeartbeatTest {

    @Autowired
    private HeartbeatSensor heartbeatSensor;


    @Test
    public void testRandomHeartbeat_should_return_a_number_between_two_values() {

        int value = heartbeatSensor.getHeartbeat();
        assertTrue(value >= 40 && value <= 230);
    }
}
