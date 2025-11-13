package app.controllers;

import app.interfaces.HeartbeatSensorDevice;
import app.models.device.BeltDevice;
import app.models.device.RingDevice;
import app.models.device.WatchDevice;
import app.models.factory.DeviceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/sensors")
public class HeartbeatDeviceController {


    @Autowired
    private DeviceFactory deviceFactory;

    private final HeartbeatSensorDevice watch;
    private final HeartbeatSensorDevice ring;
    private final HeartbeatSensorDevice belt;


    public HeartbeatDeviceController(DeviceFactory deviceFactory) {
        this.deviceFactory = deviceFactory;
        this.watch = deviceFactory.getDevice(WatchDevice.BEAN_ID);
        this.ring = deviceFactory.getDevice(RingDevice.BEAN_ID);
        this.belt = deviceFactory.getDevice(BeltDevice.BEAN_ID);
    }


    @GetMapping
    public List<HeartbeatSensorDevice> getDevice() {

        return watch.getAllHeartbeatDevice();
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
