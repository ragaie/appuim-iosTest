import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VistAndDonate {
    By skipForNow = By.id("Skip for now");
    By skip = By.id("Skip");
    By sideMenu = By.id("main_menu_icon_off");
    By faceBook = By.id("faceBookButton");
    By donateButton = By.id("causeUrgentDonate");
    By selectNetwork = By.id("picker Select mobile network");
    By pickerView = By.id("pickerView");
    By doneButton = By.id("DoneAction");
    By selectAmount = By.id("picker Select donation amount");
    By payAction = By.id("PayAction");
     AppiumDriver<MobileElement> driver;
     WebDriverWait  wait;
     @Test
    public  void setupIosCapability() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        //for ios
        cap.setCapability("deviceName","iPhone 11 Pro Max");
        cap.setCapability("platformVersion","13.3");
        cap.setCapability("udid","27C73CC1-E5CC-4CAB-9DFB-4667534D64B5");
        cap.setCapability("platformName","iOS");
        cap.setCapability("app", "/Users/ragaiealfy/Desktop/Swift UI & combinee/Welcome_To_SwiftUI/build/Release-iphonesimulator/Welcome_To_SwiftUI.app");

        URL url = new URL(" http://0.0.0.0:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
         wait = new WebDriverWait(driver, 30);
         System.out.println("application started ......");

        skipLoginAndwelcomeTour();

        reviewSidemenu();

        selectFirstUrgentCaseDonnation();

        choosenetwork();
        chooseAmount();

        takeDonateAction();
     }

     public void skipLoginAndwelcomeTour(){
         MobileElement one = driver.findElement(skipForNow);
         one.click();
         wait.until(ExpectedConditions.elementToBeClickable(skip)).click();
     }
     public void reviewSidemenu(){
         wait.until(ExpectedConditions.elementToBeClickable(sideMenu)).click();
         wait.until(ExpectedConditions.elementToBeClickable(faceBook));
         driver.findElement(sideMenu).click();
     }

     public void selectFirstUrgentCaseDonnation(){
          driver.findElement(donateButton).click();
     }

     public void choosenetwork(){
         wait.until(ExpectedConditions.elementToBeClickable(selectNetwork)).click();
         // find the picker elements
         List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickerView));
         pickerEls.get(0).findElements(MobileBy.className("UIAPickerWheel")).get(0).sendKeys("du");
          driver.findElement(doneButton).click();


     }

     public void chooseAmount(){
          driver.findElement(selectAmount).click();
         List<WebElement> pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickerView));
         pickerEls = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pickerView));
         pickerEls.get(0).findElements(MobileBy.className("UIAPickerWheel")).get(0).sendKeys("50");
          driver.findElement(doneButton).click();

     }

     public void takeDonateAction(){
         driver.findElement(payAction).click();
     }
    }
