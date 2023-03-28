package com.deque.type;

import com.deque.controller.DeviceBucket;
import com.deque.objects.InstanceRecording;
import com.deque.register.I;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author jitendra.pisal
 */
public class Switch {
    private final WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();

    public Switch(){}

    public void switchToFrame(WebElement locator){
        I.amPerforming().waitFor().waitForFrameToBeAvailableAndSwitchToIt(locator);
        //this.driver.switchTo().frame(locator);
    }

    public void switchToFrame(int id){
        this.driver.switchTo().frame(id);
    }

    public void switchToFrame(String str){
        I.amPerforming().waitFor().waitForFrameToBeAvailableAndSwitchToIt(str);
    }

    public void switchToParentFrame(){
        this.driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent(){
        this.driver.switchTo().defaultContent();
    }
}
