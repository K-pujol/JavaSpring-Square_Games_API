package app.models.device;

import org.springframework.stereotype.Service;

@Service(WatchDevice.BEAN_ID)
public class WatchDevice extends Device {
    public static final String BEAN_ID = "WatchDevice";

    @Override
    public String getName() {
        return "Bague";
    }
}

