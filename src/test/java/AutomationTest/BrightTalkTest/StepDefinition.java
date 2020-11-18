package AutomationTest.BrightTalkTest;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static AutomationTest.BrightTalkTest.BasePage.driver;
import static AutomationTest.BrightTalkTest.HomePage.homePage;

public class StepDefinition {
    public String currentUrl = null;
    int totalUserCount;
    int userIDCount;

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        homePage();
    }

    @Given("^I get the default list of users for on (\\d+)st page$")
    public void i_get_the_default_list_of_users_for_on_st_page(int page) throws Throwable {

        driver.get("https://reqres.in/");
        driver.findElement(By.cssSelector("[data-id='users']")).click();
        driver.findElement(By.xpath("//section[@id='console']/div[2]/div/p/strong/a/span")).click();
        currentUrl = driver.getCurrentUrl();
        currentUrl = currentUrl.substring(0, currentUrl.length() -1 ) + "1";
        driver.get(currentUrl);
        String value = driver.findElement(By.xpath("//pre[contains(text(),'per_page')]")).getText();
        JSONObject json = new JSONObject(value);
        int listUsersforFristPage = json.getInt("per_page");
        //TODO: assertEquals

        totalUserCount = json.getInt("total");
        // TODO: assertEquals


        Thread.sleep(1000);
    }


    @When("^I get the list of all users$")
    public void i_get_the_list_of_all_users() throws Throwable {
        // driver.get(currentUrl);
        int lastIndex = currentUrl.lastIndexOf("?");
        currentUrl = currentUrl.replace(currentUrl.substring(lastIndex), "?per_page=12");
        driver.get(currentUrl);
        String value = driver.findElement(By.xpath("//pre[contains(text(),'per_page')]")).getText();
        JSONObject json = new JSONObject(value);
        userIDCount = json.getJSONArray("data").length();


    }

    @Then("^I should see total users count equals to number of user ids$")
    public void i_should_see_total_users_count_equals_to_number_of_user_ids() throws Throwable {

        Assert.assertEquals(totalUserCount,userIDCount, "Total User Count is equals to Total user id count" );
    }

    @Given("^I make a search for user (\\d+)$")
    public void i_make_a_search_for_user(int userID) throws Throwable {
        driver.get("https://reqres.in/");
        driver.findElement(By.cssSelector("[data-id='users-single']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'/api/users/2')]")).click();
        currentUrl = driver.getCurrentUrl();
        currentUrl = currentUrl.substring(0, currentUrl.length() -1 ) + userID;
        driver.get(currentUrl);

        Thread.sleep(1000);

    }

    @Then("^I should see following user data$")
    public void i_should_see_following_user_data(DataTable userData) throws Throwable {

        List<String> userDetails = userData.asList(String.class);

        String value = driver.findElement(By.xpath("//pre[contains(text(),'data')]")).getText();

        JSONObject json = new JSONObject(value);
        JSONObject dataResponse  = json.getJSONObject("data");
        Assert.assertEquals(dataResponse.get(userDetails.get(0)), userDetails.get(2));
        Assert.assertEquals(dataResponse.get(userDetails.get(1)), userDetails.get(3));

    }

    @Then("^I receive error code 404 in response$")
    public void i_receive_error_code_enter_value_in_response() throws Throwable {
       String expectedErrorCode = driver.findElement(By.xpath("//span[contains(text(),'404')]")).getText();
       Assert.assertEquals(404, expectedErrorCode, "Expected Error Code Returned");

    }

    @Given("^I create user with following Peter Manager$")
    public void i_create_user_with_following_Peter_Manager() throws Throwable {

    }

    @Then("^response should contain folowing data$")
    public void response_should_contain_folowing_data(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
    }

    @Given("^I create user with following Liza Sales$")
    public void i_create_user_with_following_Liza_Sales() throws Throwable {

    }

    @Given("^I login succesfully with following data$")
    public void i_login_succesfully_with_following_data(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
    }

    @Given("^I login unsuccesfully with following data$")
    public void i_login_unsuccesfully_with_following_data(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
    }

    @Given("^I wait for user list to load$")
    public void i_wait_for_user_list_to_load() throws Throwable {

    }

    @Then("^I should see that every user has a unique id$")
    public void i_should_see_that_every_user_has_a_unique_id() throws Throwable {

    }
}