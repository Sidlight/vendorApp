package xyz.sidlight.vendorapp.gpio;

import java.io.IOException;

public class GpioService {


    private boolean isOn;
    private static GpioService gpioService;

    private GpioService() {
        System.out.println("GPIO service init");
        this.isOn = false;
    }

    public static GpioService getInstance() {
        if (gpioService == null) {
            gpioService = new GpioService();
        }
        return gpioService;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void on() throws IOException {
        Runtime.getRuntime().exec("gpio mode 2 out");
        Runtime.getRuntime().exec("gpio write 2 1");
        System.out.println("GPIO on");
        this.isOn = true;
    }

    public void off() throws IOException {
        System.out.println("GPIO off");
        Runtime.getRuntime().exec("gpio write 2 1");
        this.isOn = false;
    }
}
