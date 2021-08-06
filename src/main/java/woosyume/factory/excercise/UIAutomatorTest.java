package woosyume.factory.excercise;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import woosyume.factory.DriverFactory;

public class UIAutomatorTest {
    private static AndroidDriver<AndroidElement> androidDriver = null;

    public static void main(String[] args) throws MalformedURLException {
        androidDriver = DriverFactory.getDriverFactory().getAndroidDriver();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
        // androidDriver.findElement(MobileBy.AndroidUIAutomator("text(\"Animation\")")).click();
        
        // Validate clickable features for all options
        System.out.println(androidDriver.findElements(MobileBy.AndroidUIAutomator("clickable(true)")).size());
        
    }
}
