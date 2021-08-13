package woosyume.iostest;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import woosyume.factory.DriverFactory;

public class AppiumGestureTest {
    private static IOSDriver<IOSElement> driver = null;

    public static void main(String[] args) throws MalformedURLException {
        driver = DriverFactory.getDriverFactory().getIOSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Use map object for indicating scroll behavior
        Map<String, Object> scroll = new HashMap<>();
        scroll.put("direction", "down");
        scroll.put("name", "Web View");

        driver.executeScript("mobile:scroll", scroll);
        driver.findElement(By.id("Web View")).click();

        // Go back
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();

        // Choose pickup value
        driver.findElement(By.id("Picker View")).click();
        driver.findElement(By.id("Red color component value")).sendKeys("80");
        driver.findElement(By.id("Green color component value")).sendKeys("220");
        driver.findElement(By.id("Blue color component value")).sendKeys("105");

        // Go back
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();

        driver.findElement(By.id("Sliders")).click();
        // Value of slider should be in 0..1 range
        IOSElement slider = driver.findElement(By.xpath("//XCUIElementTypeSlider"));
        slider.setValue("0");
        slider.setValue("0.7");
        slider.setValue("1");
     }
}
