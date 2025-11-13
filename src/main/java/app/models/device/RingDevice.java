package app.models.device;

import org.springframework.stereotype.Service;

@Service(RingDevice.BEAN_ID)
public class RingDevice extends Device {
    public static final String BEAN_ID = "HeartbeatSensorDevice";

    @Override
    public String getName() {
        return "Bague";
    }
}

