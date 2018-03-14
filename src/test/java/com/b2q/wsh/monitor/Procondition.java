package com.b2q.wsh.monitor;

import com.b2q.wsh.Browser.WebDriverChoose;
import com.b2q.wsh.pages.LoginNote;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Procondition {
    public WebDriver driver;
    @BeforeMethod
    public void beforesuiteTest() {
        driver = WebDriverChoose.getDriver("chrome",this.getClass());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://account.b2q.com/login.html");
        LoginNote loginNote=new LoginNote(driver);
        loginNote.golongin("chuhui","123456");
    }
    @AfterMethod
    public void aftermethodTest(){
        driver.quit();
        System.out.println("afterMethod后置处理");
    }
}
