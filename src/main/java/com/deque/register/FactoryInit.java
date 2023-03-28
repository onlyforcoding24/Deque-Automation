package com.deque.register;

import com.deque.misclib.FileHandler;
import com.deque.objects.InstanceRecording;
import com.deque.type.Click;
import com.deque.type.Elements;
import com.deque.type.Switch;
import com.deque.type.TextInput;
import io.cucumber.java.Before;

/**
 * @author jitendra.pisal
 */
public class FactoryInit {

    public FactoryInit() {
        InstanceRecording.recordInstance(TextInput.class, new TextInput());
        InstanceRecording.recordInstance(Click.class, new Click());
        InstanceRecording.recordInstance(Switch.class, new Switch());
        InstanceRecording.recordInstance(Elements.class, new Elements());
        InstanceRecording.recordInstance(FileHandler.class, new FileHandler());
    }

    @Before(
            order = 1
    )
    public void startActionsRegistration() {
    }
}
