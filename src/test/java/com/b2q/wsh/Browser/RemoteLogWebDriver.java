package com.b2q.wsh.Browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.NoSuchElementException;

import java.net.URL;

public class RemoteLogWebDriver extends RemoteWebDriver {
    private Logger logger;
    public RemoteLogWebDriver(URL url, Capabilities cps,Class<?> clazz){
        super(url,cps);
        logger = LogManager.getLogger(clazz);
    }

    @Override
    public WebElement findElementById(String using) {
       try {
           WebElement element = super.findElementById(using);
            logger.info(using+"定位已找到元素");
           return element;
       }catch (NoSuchElementException e){
           logger.info(using+"定位未找到元素");
           throw e;
       }
    }

    @Override
    public WebElement findElementByName(String using) {
        try {
            WebElement element = super.findElementByName(using);
            logger.info(using+"定位已找到元素");
            return element;
        }catch (NoSuchElementException e){
            logger.info(using+"定位未找到元素");
            throw e;
        }
    }

    @Override
    public WebElement findElementByXPath(String using) {
        try {
            WebElement element = super.findElementByXPath(using);
            logger.info(using+"定位已找到元素");
            return element;
        }catch (NoSuchElementException e){
            logger.info(using+"定位未找到元素");
            throw e;
        }
    }




}
