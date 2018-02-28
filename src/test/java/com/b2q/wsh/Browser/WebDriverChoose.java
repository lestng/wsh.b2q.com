package com.b2q.wsh.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;

public class WebDriverChoose {
    private WebDriverChoose(){};
    private static DriverService service;

    /*static {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\java\\selenium\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getChromeDriver() {
        URL url = service.getUrl();
        WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
        return driver;
    }

    public static void stopService() {
        service.stop();
    }
*/
    public static WebDriver getDriver(String BrowserName,Class<?> clazz) {
        WebDriver driver=null;
        //启用service
        if (service == null) {
            if (BrowserName.equalsIgnoreCase("chrome")) {
                service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("C:\\java\\selenium\\chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
            } else if (BrowserName.equalsIgnoreCase("firefox")) {
                service = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("C:\\java\\selenium\\geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
            } else if (BrowserName.equalsIgnoreCase("ie")) {
                service = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(new File("C:\\java\\selenium\\IEDriverServer.exe"))
                        .usingAnyFreePort()
                        .build();
            } else {
                System.err.println("浏览器类型不支持");
                return null;
            }
            try {
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //启用driver
        if (BrowserName.equalsIgnoreCase("chrome")){
            driver = new RemoteLogWebDriver(service.getUrl(),DesiredCapabilities.chrome(),clazz);
        }else if (BrowserName.equalsIgnoreCase("firefox")){
            driver = new RemoteLogWebDriver(service.getUrl(),DesiredCapabilities.firefox(),clazz);
        }else if (BrowserName.equalsIgnoreCase("ie")){
            driver = new RemoteLogWebDriver(service.getUrl(),DesiredCapabilities.internetExplorer(),clazz);
        }else {
            System.err.println("");
            return null;
        }
        return driver;
    }

    public static void stopService() {
        if (service != null)
            service.stop();
    }

}
