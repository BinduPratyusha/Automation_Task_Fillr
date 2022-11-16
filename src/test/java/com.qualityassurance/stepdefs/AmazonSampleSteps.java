package com.qualityassurance.stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;

public class AmazonSampleSteps {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    AndroidDriver driver = new AndroidDriver(capabilities);

    @BeforeTest
    public void initConfig() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("Setting up the desired capabilities");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy F12");
        capabilities.setCapability(MobileCapabilityType.UDID,"RZ8T303AJ5Y");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.BROWSER_VERSION,"2.18");
        System.out.println("Establishing connection with appium server");
        driver.wait(50000);
        URL url = new URL("https://127.0.0.1:4723/");
        AndroidDriver androidDriver = new AndroidDriver(url,capabilities);
    }
    @Given("I Open the Browser")
    public void i_open_the_browser() throws MalformedURLException {
        System.out.println("In open browser");
    }
    @And("I Navigate to the URL")
    public void i_navigate_to_the_url() throws InterruptedException {
        driver.get("https://www.amazon.com.au");
    }

    @When("I search for a product")
    public void i_search_for_a_product() {
        WebElement searchTextbox = driver.findElement(By.id("nav-search-keyboards"));
        searchTextbox.click();
        System.out.println("Clicked on the search text box so that will be able to enter the text in this field");
        searchTextbox.sendKeys("Apple");
        System.out.println("Entered text Apple in the text box");
        WebElement searchIcon = driver.findElement(By.xpath("//input[@type='submit']"));
        searchIcon.click();
        System.out.println("Clicked on the search icon");

    }

    @Then("Search result is displayed")
    public void search_result_is_displayed() {
        WebElement resultsPage = driver.findElement(By.xpath("//span[@text='RESULTS']"));
        resultsPage.isDisplayed();
        System.out.println("Search results are displayed by verifying the search result page text");
    }
    @When("I Open the item")
    public void i_open_the_item(){
        WebElement selectAnItem = driver.findElement(By.xpath("//span[contains(@text,'Apple iPad')]"));
        selectAnItem.click();
        System.out.println("Clicked on the item");
        WebElement itemTitle = driver.findElement(By.id("title"));
        System.out.println("Verifying if the item is opened or expanded");
        itemTitle.isDisplayed();
        System.out.println("Item is opened");
    }
    @And("Add the item to cart")
    public void add_the_item_to_cart(){
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        Actions action = new Actions(driver);
        action.scrollToElement(addToCart);
        action.perform();
        System.out.println("Scrolled to the Add to cart button");
        addToCart.click();
        System.out.println("Add to cart button is clicked");
    }

    @Then("Cart page is displayed")
    public void cart_page_is_displayed() {
        WebElement cartPage = driver.findElement(By.xpath("//span[@text='Subtotal']"));
        cartPage.isDisplayed();
        System.out.println("Cart page is displayed");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION,"LANDSCAPE");
        System.out.println("Screen orientation is changed to Landscape mode");
    }
    @AfterTest
    public void close(){
        driver.quit();
    }
}

 

 