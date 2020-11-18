package AutomationTest.BrightTalkTest;

import org.openqa.selenium.By;

import static AutomationTest.BrightTalkTest.LoadProp.getproperty;

public class HomePage extends BasePage {

    public static void homePage() {
        driver.get(getproperty("url"));
    }

    public static void navigateToHomePage(){
        driver.get(getproperty("reqres_url"));
    }

    public static void returnListOfDefaultUsers(){
        driver.findElement(By.cssSelector("[data-id='users']")).click();

    }
}
