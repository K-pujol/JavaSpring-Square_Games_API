package app.models.device;

import app.interfaces.HeartbeatSensorDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(BeltDevice.BEAN_ID)
public class BeltDevice extends Device {
    public static final String BEAN_ID = "BeltDevice";

    @Override
    public String getName() {
        return "Ceinture";
    }

    @Override
    public List<HeartbeatSensorDevice> getAllHeartbeatDevice() {
        return List.of();
    }
}

