package woosyume.factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
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
    private static File ECOMMERCE_APK = new File(PATH, "General-Store.apk");

    public AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {
        // Load apk file.

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
        cap.setCapability(MobileCapabilityType.APP, APK.getAbsolutePath());
        
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(APPIUM_HOST), cap);        
        return driver;
    }

    // This is for the case of using real device. (But I don't have private android device...)
    public AndroidDriver<AndroidElement> getAndroidDriver(String device) throws MalformedURLException {
        // Load apk file.

        DesiredCapabilities cap = new DesiredCapabilities();
        if (device.equals("emulator")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
            
        } else if (device.equals("real")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Real Device"); // TODO Fix the actual device name.

        }
        cap.setCapability(MobileCapabilityType.APP, ECOMMERCE_APK.getAbsolutePath());
        
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(APPIUM_HOST), cap);        
        return driver;
    }

    public AndroidDriver<AndroidElement> getAndroidChromeDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 30");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);       
        return driver;
    }

    public IOSDriver<IOSElement> getIOSDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, Duration.ofSeconds(50));
        cap.setCapability("commandTimeouts", "12000");
        // cap.setCapability(MobileCapabilityType.APP, "iosapp/UIKitCatalog.app");
        cap.setCapability(MobileCapabilityType.APP, "/Users/woohyeok.kim/Desktop/study/appium/iosapp/UIKitCatalog.app");
        
        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
    }

    public IOSDriver<IOSElement> getIOSDriverForLongPress() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, Duration.ofSeconds(50));
        cap.setCapability("commandTimeouts", "12000");
        cap.setCapability(MobileCapabilityType.APP, "/Users/woohyeok.kim/Desktop/study/appium/iosapp/longtap.app");
        
        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
    }
}
