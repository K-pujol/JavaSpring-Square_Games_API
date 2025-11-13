package app.interfaces;


import java.util.List;
import java.util.Random;

public interface HeartbeatSensorDevice {

    Random random = new Random();

    String getId();
    String getName();

    List<HeartbeatSensorDevice> getAllHeartbeatDevice();
    String getHeartbeatDevice(int id);
    String updateHeartbeatDevice(int id);
    String createHeartbeatDevice();
    String deleteHeartbeatDevice(int id);
}
