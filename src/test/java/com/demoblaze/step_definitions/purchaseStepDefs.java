package com.demoblaze.step_definitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AdidasPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class purchaseStepDefs {
    AdidasPage adidasPage = new AdidasPage();
    int expectedPurchaseAmount = 0;



    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
       expectedPurchaseAmount+= adidasPage.productAdder(category,product);
    }
}
