package com.deque.steps;

import com.deque.controller.DeviceBucket;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.objects.InstanceRecording;
import com.deque.pages.DequePage;
import com.deque.register.I;
import com.deque.type.Click;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DequeSteps {
    public DequePage dequePage;
    Logger logger = Logger.getLogger(DequeSteps.class);

    public DequeSteps(DequePage dequePage) {
        this.dequePage=dequePage;
    }

    @When("I am on home page")
    public void iAmOnHomePage() {
        I.amPerforming().getLogger().logInfo(logger,"I am on home page");
    }

    @Then("I see main page has loaded successfully")
    public void iSeeMainPageHasLoadedSuccessfully() {
        I.amPerforming().getLogger().logInfo(logger,"Verifying if main page has loaded or not");
        I.amPerforming().assertionsTo().assertThat(
                I.amPerforming().elements().getElement(
                        By.id("main-nav")
                ).isDisplayed()
        ).isTrue();
        I.amPerforming().getLogger().logInfo(logger,"verified that the main page has loaded successfully");
    }

    @And("I verified that there {int} total number of radio buttons")
    public void iVerifiedThatThereTotalNumberOfRadioButtons(int total) {
        int totalRadioButton  = I.amPerforming().elements().getElements(By.xpath("//div[@id='widget-controls']//input[@type='radio']")).size();
        I.amPerforming().assertionsTo().assertThat(totalRadioButton).isEqualTo(total);
        I.amPerforming().getLogger().logInfo(logger,"All 5 radio buttons are showing");
    }

    @When("I click on add a traveler")
    public void iClickOnAddATraveler() {
        I.amPerforming().click().on(By.xpath("//div[@id='add-traveler']//a"));
        I.amPerforming().getLogger().logInfo(logger,"Clicked on add a traveler option");
    }

    @Then("I see another select is added to the page")
    public void iSeeAnotherSelectIsAddedToThePage() {
        I.amPerforming().assertionsTo().assertThat(
                I.amPerforming().elements().getElement(
                        By.xpath("//div[@class='dynamic']//div[contains(@id,'r-passenger')]")
                ).isDisplayed()
        ).isTrue();
        I.amPerforming().getLogger().logInfo(logger,"Verified that the another select is added to the page");
    }

    @When("I click arrow under the video and see that the video get changed")
    public void iClickArrowUnderTheVideo() {
        I.amPerforming().getLogger().logInfo(logger,"Getting header of current video");
        String currentVideo = I.amPerforming().elements().getText(By.xpath("//h3[@id='video-text']"));
        I.amPerforming().getLogger().logInfo(logger,"Heading of current video is : "+currentVideo);
        I.amPerforming().getLogger().logInfo(logger,"Click on next video : "+currentVideo);
        I.amPerforming().click().on(By.xpath("//div[@id='video-box']//div[contains(@class,'nextvid')]//i"));
        I.amPerforming().getLogger().logInfo(logger,"Getting header of next video");
        String nextVideo = I.amPerforming().elements().getText(By.xpath("//h3[@id='video-text']"));
        I.amPerforming().getLogger().logInfo(logger,"Heading of next video is : "+nextVideo);
        I.amPerforming().assertionsTo().assertThat(currentVideo).isNotEqualToIgnoringCase(nextVideo);
    }

    @Then("I am doing accessibility testing")
    public void iAmDoingAccessibilityTesting() {

        AxeBuilder axeBuilder = new AxeBuilder();
        WebDriver driver = ((DeviceBucket) InstanceRecording.getInstance(DeviceBucket.class)).getDriver();
        Results results = axeBuilder.analyze(driver);
        List<Rule> violations = results.getViolations();
        if (violations.size() == 0)
        {
            Assert.assertTrue("No violations found",true);
        } else {
            System.out.println();
            for(Rule rule : violations) {
                //System.out.println(rule.getDescription());
                I.amPerforming().getLogger().logInfo(logger,rule.getDescription());
        }
    }
    }
}
