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
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }

    @When("User removes {string} from cart")
    public void user_removes_from_cart(String product) {
       expectedPurchaseAmount-=adidasPage.productRemover(product);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }

    @When("User places order and captures and logs purchase ID and Amount")
    public void user_places_order_and_captures_and_logs_purchase_id_and_amount() {
        adidasPage.cart.click();
        adidasPage.placeOrder.click();

        adidasPage.fillForm();
        adidasPage.purchaseButton.click();

        String confirmation = adidasPage.confirmation.getText();
        System.out.println("confirmation = " + confirmation);

        String [] confirmationArray = confirmation.split(" \n ");




    }
    @When("User verifies purchase amount equals expected")
    public void user_verifies_purchase_amount_equals_expected() {

    }

}
