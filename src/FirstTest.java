import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  FirstTest{

    private AppiumDriver driver;
    @Before
    public void setup() throws Exception
    {

        DesiredCapabilities capabilities= new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","and80");
        capabilities.setCapability("platformVersion","8.1");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app","C:/Users/Natalia/OneDrive/Рабочий стол/JavaAppiumAutomation/apk/org.wikipedia.apk");

        driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
    @Test

    public void firstTest()
    {
        assertElementHasText(
                By.xpath("//*[contains(@text,'Featured article')]"),
                "Cannot find Featured article",
                5

       );


            assertElementHasText(
                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                    "Cannot find Search Wikipedia",
                    5

            );
     }

    private WebElement assertElementHasText(By by, String error_message, long timeoutInSeconds)
{
    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    wait.withMessage(error_message + "/n");
    return wait.until(
            ExpectedConditions.presenceOfElementLocated(by)

    );
}

    }

