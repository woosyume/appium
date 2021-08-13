package woosyume.iostest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import woosyume.factory.DriverFactory;

public class AppiumClickTest {
    private static IOSDriver<IOSElement> driver = null;

    public static void main(String[] args) throws MalformedURLException {
        driver = DriverFactory.getDriverFactory().getIOSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("Alert Views")).click();
        driver.findElement(By.id("Text Entry")).click();

        driver.findElement(By.xpath("//XCUIElementTypeCell")).sendKeys("woosyume");
        driver.findElement(By.id("OK")).click();

        driver.findElement(By.id("Confirm / Cancel")).click();
        driver.findElement(By.id("Confirm")).click();
    }
}
