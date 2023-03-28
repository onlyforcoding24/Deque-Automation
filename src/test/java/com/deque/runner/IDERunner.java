package com.deque.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * IDE runner class. Place any tag name in tags and it will run the specific tag
 * through IDE . Can be used to debug code as well.
 * Only designed to open chrome browser by default
 *
 * @author jitendra.pisal
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"Setup","com.deque.steps","com.deque.register"},
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-html",},
        tags = {"@test"},
        monochrome = true
)

public class IDERunner {
    @BeforeClass
    public static void init(){
        BasicConfigurator.configure();
        Logger.getLogger("org.apache.http").setLevel(Level.OFF);
        Logger.getLogger("io.restassured.internal").setLevel(Level.OFF);
    }
}

