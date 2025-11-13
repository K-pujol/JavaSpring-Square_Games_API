package app.controllers;

import app.interfaces.HeartbeatSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * class use for API
 */

@RestController
@RequestMapping("/heartbeat")
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;

    /**
     * calling method getHeartbeat from RandomHeartbeat with the @autowired of HeartbeatSensor (interface)
     *
     * @return a number between 2 values >
     * @see app.models.RandomHeartbeat
     */

    @GetMapping
    public int getHeartbeat() {
        return heartbeatSensor.getHeartbeat();
    }
}
