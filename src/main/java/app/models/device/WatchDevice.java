package app.models.device;

import app.interfaces.HeartbeatSensorDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(WatchDevice.BEAN_ID)
public class WatchDevice extends Device {
    public static final String BEAN_ID = "WatchDevice";

    @Override
    public String getName() {
        return "Bague";
    }

    @Override
    public List<HeartbeatSensorDevice> getAllHeartbeatDevice() {
        return List.of();
    }
}

