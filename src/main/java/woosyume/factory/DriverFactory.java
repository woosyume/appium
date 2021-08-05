package woosyume.factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
    private DriverFactory() {}
    private static DriverFactory factory = new DriverFactory();

    public static DriverFactory getDriverFactory() {
        return factory;
    }

    private static String APPIUM_HOST = "http://0.0.0.0:4723/wd/hub";
    private static File PATH = new File("apk");
    private static File APK = new File(PATH, "ApiDemos-debug.apk");

    public AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {
        // Load apk file.

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
        cap.setCapability(MobileCapabilityType.APP, APK.getAbsolutePath());
        
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(APPIUM_HOST), cap);        
        return driver;
    }
}
