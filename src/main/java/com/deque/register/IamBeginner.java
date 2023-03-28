package com.deque.register;

import com.deque.controller.DeviceBucket;
import com.deque.controller.Factory;
import com.deque.controller.TestSetUpController;
import com.deque.objects.InstanceRecording;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.BasicConfigurator;

import java.awt.*;
import java.io.IOException;

/**
 * @author jitendra.pisal
 */
public final class IamBeginner {
    private TestSetUpController registerSetup;

    public IamBeginner(DeviceBucket device, Factory coreLib, TestSetUpController registerSetup) {
        this.registerSetup = registerSetup;
        InstanceRecording.recordInstance(Factory.class, coreLib);
        InstanceRecording.recordInstance(DeviceBucket.class, device);
    }

    @Before(
            order = 0
    )
    public void registerSetup(Scenario scenario) throws IOException, AWTException {
        this.registerSetup.initializer(scenario);
    }

    @After(
            order = 9999
    )
    public void unRegisterSetup() throws IOException {
        this.registerSetup.theEnd();
        BasicConfigurator.resetConfiguration();
    }

}
