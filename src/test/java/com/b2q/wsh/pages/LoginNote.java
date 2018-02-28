package com.b2q.wsh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class LoginNote {
    /**
     * 会员中心登录的用户名
     */
    @FindBy(name = "UserName")
    public WebElement username_login;
    @FindBy(name = "Password")
    public WebElement password_login;
    @FindBy(xpath ="//input[@type='submit']")
    public WebElement logbtn_login;
    /*@FindBy(xpath = "//a[@href='/Home/Index']")
    public WebElement login_examine;*/
    @FindBy(xpath = "//div[@class='layui-layer-content layui-layer-padding']")
    public WebElement login_test;

    public LoginNote(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    /**
     * 进行会员中心登录操作
     * @param username  登录用户名
     * @param password  登录密码
     */
    public void golongin(String username,String password){
        username_login.sendKeys(username);
        password_login.sendKeys(password);
        logbtn_login.click();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void examineLogin(String practical){
        Assert.assertEquals(login_test.getText(),practical);
    }

}
