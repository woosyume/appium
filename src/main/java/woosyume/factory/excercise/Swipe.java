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
import io.appium.java_client.touch.offset.ElementOption;
import woosyume.factory.DriverFactory;

public class Swipe {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException {
        androidDriver = DriverFactory.getDriverFactory().getAndroidDriver();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Date Widgets\")")).click();
        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"2. Inline\")")).click();

        // UiSelector has no `content-desc` method
        androidDriver.findElement(By.xpath("//*[@content-desc='9']")).click();

        TouchAction action = new TouchAction<>(androidDriver);
        WebElement element15 = androidDriver.findElement(By.xpath("//*[@content-desc='15']"));
        WebElement element45 = androidDriver.findElement(By.xpath("//*[@content-desc='45']"));
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element15)).withDuration(Duration.ofSeconds(2)))
        .moveTo(ElementOption.element(element45)).release().perform();
    }
}
