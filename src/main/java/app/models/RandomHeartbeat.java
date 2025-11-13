package app.models;

import app.interfaces.HeartbeatSensor;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * class use to get random heartbeat
 */

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    /**
     * method that return a random number between 2 values
     * @return
     */

    @Override
    public int getHeartbeat() {
        int min = 40;
        int max = 230;
        Random random = new Random();
        return random.nextInt(max + min + 1) + min;
    }
}
