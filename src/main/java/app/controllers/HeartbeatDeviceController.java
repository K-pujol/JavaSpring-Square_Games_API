package app.controllers;

import app.interfaces.HeartbeatSensorDevice;
import app.models.device.BeltDevice;
import app.models.device.RingDevice;
import app.models.device.WatchDevice;
import app.models.factory.DeviceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sensors")
public class HeartbeatDeviceController {



    private final Map<String, HeartbeatSensorDevice> devices;

    public HeartbeatDeviceController(Map<String, HeartbeatSensorDevice> devices) {
        this.devices = devices;
    }

    @GetMapping
    public List<HeartbeatSensorDevice> getAllDevices() {
        return new ArrayList<>(devices.values());
    }

    @GetMapping("/{type}")
    public HeartbeatSensorDevice getDeviceByType(@PathVariable String type) {
        return devices.get(type);
    }
/*
    @GetMapping("/sensors")
    public String getAllHeartbeatDevice() {


        return watch.);
    }

    @GetMapping("/sensors/{id}")
    public String getHeartbeatDevice(@PathVariable int id) {
        return deviceFactory.getDevice(HeartbeatSensorDevice.BEAN_ID).getHeartbeatDevice(id);
    }

    @PutMapping("/sensors/{id}")
    public String updateHeartbeatDevice(@PathVariable int id) {
        return deviceFactory.getDevice(HeartbeatSensorDevice.BEAN_ID).updateHeartbeatDevice(id);
    }

    @PostMapping("/sensors")
    public String createHeartbeatDevice() {
        return deviceFactory.getDevice(HeartbeatSensorDevice.BEAN_ID).createHeartbeatDevice();
    }

    @DeleteMapping("/sensors/{id}")
    public String deleteHeartbeatDevice(@PathVariable int id) {
        return deviceFactory.getDevice(HeartbeatSensorDevice.BEAN_ID).deleteHeartbeatDevice(id);
    }*/
}
