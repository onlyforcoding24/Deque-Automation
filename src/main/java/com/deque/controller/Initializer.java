package com.deque.controller;

import org.openqa.selenium.WebDriver;

/**
 * @author jitendra.pisal
 */
public interface Initializer {
    WebDriver getDriver();
    void setUpController();
}
