package com.deque.register;

import com.deque.controller.Factory;
import com.deque.objects.InstanceRecording;

/**
 * @author jitendra.pisal
 */
public class I {
    public I(){

    }

    public static Factory amPerforming(){
        return (Factory)InstanceRecording.getInstance(Factory.class);
    }
}
