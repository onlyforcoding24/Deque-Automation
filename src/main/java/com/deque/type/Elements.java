package com.deque.type;

import com.deque.controller.DeviceBucket;
import com.deque.objects.InstanceRecording;
import com.deque.register.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * @author jitendra.pisal
 */
public class Elements {
    private final WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();

    public Elements() {
    }

    public WebElement getElement(By by) {
        I.amPerforming().waitFor().getWait().until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
        return this.driver.findElement(by);
    }

    public List<WebElement> getElements(By by) {
        I.amPerforming().waitFor().getWait().until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
        return this.driver.findElements(by);
    }

    public String getText(By locator) {
        return this.getElement(locator).getText();
    }
}
