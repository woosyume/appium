package woosyume.factory.excercise;

import java.net.MalformedURLException;
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

public class DragAndDrop {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException {
        androidDriver = DriverFactory.getDriverFactory().getAndroidDriver();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Drag and Drop\")")).click();

        WebElement source = androidDriver.findElementsByClassName("android.widget.TextView").get(0);
        WebElement dest = androidDriver.findElementsByClassName("android.widget.TextView").get(1);
        TouchAction action = new TouchAction<>(androidDriver);

        // FIXME Not sure this is working or not. Cannot see the behavior but error is not happened.
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
        .moveTo(ElementOption.element(dest)).release().perform();

        System.out.println("haha");
    }
}
