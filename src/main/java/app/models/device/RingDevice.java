package app.models.device;

import app.interfaces.HeartbeatSensorDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(RingDevice.BEAN_ID)
public class RingDevice extends Device {
    public static final String BEAN_ID = "HeartbeatSensorDevice";

    @Override
    public String getName() {
        return "Bague";
    }

    @Override
    public List<HeartbeatSensorDevice> getAllHeartbeatDevice() {
        return List.of();
    }
}

