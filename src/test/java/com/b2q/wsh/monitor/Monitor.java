package com.b2q.wsh.monitor;

import com.b2q.wsh.Browser.WebDriverChoose;
import org.testng.annotations.AfterSuite;

public class Monitor {
    @AfterSuite
    public void afterSuiteTest(){
        WebDriverChoose.stopService();
        System.out.println("Monitor后置处理");
    }

}
