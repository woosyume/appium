package woosyume.iostest;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import woosyume.factory.DriverFactory;

public class AppiumLongPressTest {
    private static IOSDriver<IOSElement> driver = null;

    public static void main(String[] args) throws MalformedURLException {
        driver = DriverFactory.getDriverFactory().getIOSDriverForLongPress();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement longtap = driver.findElementByName("Long tap");

        TouchAction<IOSTouchAction> touch = new IOSTouchAction(driver);
        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longtap)).withDuration(Duration.ofSeconds(2))).release().perform();

        MobileElement switchName = driver.findElementByXPath("//XCUIElementTypeSwitch[1]");
        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchName))).perform();

        MobileElement switchMail = driver.findElementByXPath("//XCUIElementTypeSwitch[2]");
        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchMail))).perform();
    }
}
