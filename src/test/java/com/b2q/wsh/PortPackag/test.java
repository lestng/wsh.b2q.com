package com.b2q.wsh.PortPackag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class test {
/*
    private HttpUtil httpUtil;

    private String url = "";
    private String charset = "UTF-8";


    private void main(String[] args) {
        httpUtil = HttpUtil.getInstance();

        Map<String,String> params = new HashMap<String, String>();
        params.put("","");
        httpUtil.doPost(url,params,charset);
    }*/
public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "C:\\java\\selenium\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.get("http://account.b2q.com/login.html");
    driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("ch1111");
    driver.findElement(By.name("Password")).sendKeys("123456");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
}
}
