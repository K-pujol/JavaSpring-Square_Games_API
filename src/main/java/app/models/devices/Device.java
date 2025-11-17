package app.models.devices;

import app.interfaces.HeartbeatSensorDevice;

public abstract class Device implements HeartbeatSensorDevice {

    @Override
    public String getId() {
        int min = 1;
        int max = 8;
        int id = random.nextInt(max + min + 1) + min;
        return "id: " + id;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getHeartbeatDevice(int id) {
        return "0";
    }

    @Override
    public String updateHeartbeatDevice(int id) {
        return "0";
    }

    @Override
    public String createHeartbeatDevice() {
        return "0";
    }

    @Override
    public String deleteHeartbeatDevice(int id) {
        return "0";
    }
}
