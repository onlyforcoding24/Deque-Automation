package com.deque.controller;

import com.deque.devices.ChromeManager;
import com.deque.devices.FireFoxManager;
import com.deque.register.EnvironmentFactory;
import org.openqa.selenium.WebDriver;

/**
 * @author jitendra.pisal
 */
public final class DeviceBucket implements Initializer{
    private final Initializer delegate;

    public DeviceBucket() {
        String var1 = EnvironmentFactory.getDevice().toLowerCase();
        switch(var1){
            case "chrome":
                this.delegate = new ChromeManager();
                break;
            case "firefox":
                this.delegate = new FireFoxManager();
                break;
            default:
                this.delegate = new ChromeManager();
        }
    }

    @Override
    public WebDriver getDriver() {
        return this.delegate.getDriver();
    }

    @Override
    public void setUpController() {
        this.delegate.setUpController();
    }
}
