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

     }
}
