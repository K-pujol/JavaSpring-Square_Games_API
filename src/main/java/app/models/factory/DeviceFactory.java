package app.models.factory;

import app.interfaces.HeartbeatSensorDevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeviceFactory {
    private final Map<String, HeartbeatSensorDevice>  heartbeatSensorDeviceMap;

    public HeartbeatSensorDevice getDevice(String DeviceType) {
        return heartbeatSensorDeviceMap.get(DeviceType);
    }
}
