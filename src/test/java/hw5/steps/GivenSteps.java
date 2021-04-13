package hw5.steps;

import io.cucumber.java.en.Given;

public class GivenSteps extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.openPage();
    }
}
