package woosyume;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class App {
    public static String APPIUM_HOST = "http://0.0.0.0:4723/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        // Load apk file.
        File path = new File("apk");
        File apk = new File(path, "ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
        cap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(APPIUM_HOST), cap);
        
    }
}
