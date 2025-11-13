package app.models.device;

import org.springframework.stereotype.Service;

@Service(BeltDevice.BEAN_ID)
public class BeltDevice extends Device {
    public static final String BEAN_ID = "BeltDevice";

    @Override
    public String getName() {
        return "Ceinture";
    }
}

