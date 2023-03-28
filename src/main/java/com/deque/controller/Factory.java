package com.deque.controller;

import com.deque.api.Wait;
import com.deque.logging.OwnLogger;
import com.deque.misclib.FileHandler;
import com.deque.misclib.PropertyFileReader;
import com.deque.objects.InstanceRecording;
import com.deque.type.Click;
import com.deque.type.Elements;
import com.deque.type.Switch;
import com.deque.type.TextInput;
import org.assertj.core.api.SoftAssertions;

/**
 * @author jitendra.pisal
 */
public final class Factory {
    private Click click;
    private PropertyFileReader propertyFileReader;
    private Wait wait;
    private TextInput textInput;
    private Switch switchTo;
    private Elements elements;
    private OwnLogger ownLogger;
    private SoftAssertions softAssertions;
    private FileHandler fileHandler;

    public Factory() {
    }

    public Wait waitFor() {
        if (this.wait == null) {
            this.wait = new Wait();
        }
        return this.wait;
    }

    public FileHandler fileHandler() {
        if (this.fileHandler == null) {
            this.fileHandler = InstanceRecording.getInstance(FileHandler.class);
        }
        return this.fileHandler;
    }

    public OwnLogger getLogger() {
        if (this.ownLogger == null) {
            this.ownLogger = new OwnLogger();
        }
        return ownLogger;
    }

    public Switch switchTo() {
        if (this.switchTo == null) {
            this.switchTo = InstanceRecording.getInstance(Switch.class);
        }
        return this.switchTo;
    }

    public TextInput textInput() {
        if (this.textInput == null) {
            this.textInput = InstanceRecording.getInstance(TextInput.class);
        }
        return this.textInput;
    }

    public Click click() {
        if (this.click == null) {
            this.click = InstanceRecording.getInstance(Click.class);
        }
        return this.click;
    }

    public PropertyFileReader propertiesFileOperationsTo() {
        if (this.propertyFileReader == null) {
            this.propertyFileReader = new PropertyFileReader();
        }
        return this.propertyFileReader;
    }

    public Elements elements() {
        if (this.elements == null) {
            this.elements = InstanceRecording.getInstance(Elements.class);
        }
        return this.elements;
    }

    public SoftAssertions assertionsTo() {
        if (this.softAssertions == null) {
            this.softAssertions = new SoftAssertions();
        }
        return this.softAssertions;
    }
}
