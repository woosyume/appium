package woosyume.factory.excercise;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import woosyume.factory.DriverFactory;

public class Gestures {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException {
        androidDriver = DriverFactory.getDriverFactory().getAndroidDriver();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();

        TouchAction action = new TouchAction(androidDriver);

        WebElement expandList = androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Expandable Lists\")"));
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandList))).perform();
        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"1. Custom Adapter\")")).click();;

        WebElement peopleName = androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"People Names\")"));
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleName)).withDuration(Duration.ofSeconds(2))).release().perform();

        // androidDriver.findElement(By.id("android:id/title")).isDisplayed();
        System.out.println("check=" + androidDriver.findElement(By.id("android:id/title")).isDisplayed());
    }
}
