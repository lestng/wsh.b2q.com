package com.b2q.wsh.test;

import com.b2q.wsh.pages.LoginNote;
import com.b2q.wsh.pages.ProductAudit;
import com.b2q.wsh.pages.Publish;
import com.b2q.wsh.monitor.Procondition;
import com.b2q.wsh.readdata.DataParamater;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WSHTest extends Procondition {
    public static Logger logger = LogManager.getLogger();
    @Test(dataProviderClass = DataParamater.class,dataProvider = "wsh_login_data",priority = 1)
    public void tologin(String username,String password,String practical){


        driver.get("http://account.b2q.com/login.html");
        LoginNote loginNote=new LoginNote(driver);
        loginNote.golongin(username,password);
        loginNote.examineLogin(practical);
        System.out.println(practical);
        logger.error("哈哈哈");
    }
   /*@Test(priority = 2)
    public void proLach(){
       Publish publish = new Publish(driver);
       publish.productLaunch("汽配产品1");

       WebElement iframe=driver.findElement(By.className("ke-edit-iframe"));
       //System.out.println(iframe);
       driver.switchTo().frame(iframe);
       publish.content_pdl.sendKeys("汽配产品描述");
       driver.switchTo().defaultContent();
       publish.submit_pdl.click();
       String cont = publish.contentlayu_pdl.getText();
       Assert.assertEquals(cont,"操作成功！");
   }*/
   @Test(priority = 3)
    public void deletePro(){
       ProductAudit proaut = new ProductAudit(driver);
       proaut.deleteProduct();
   }

}
