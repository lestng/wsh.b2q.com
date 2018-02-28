package com.b2q.wsh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Publish {
    /*public WebDriver driver;
    Select select = new Select(driver.findElement(By.id("Select0")));*/
    /**
     * 会员中心中的销售中心链接
     */
    @FindBy(xpath = "//a[@href = '/Business/Order']")
    public WebElement business_order;
    /**
     * 会员中心 销售中心中的发布产品链接
     */
    @FindBy(xpath = "//a[@href ='/Business/ProductInfo']")
    public WebElement publish_proinfo;
    /**
     *会员中心 销售中心 发布产品页面中的产品一级目录
     */
    @FindBy(id = "Select0")
    public WebElement select0_pbl;
    /**
     *会员中心 销售中心 发布产品页面中的产品二级目录
     */
    @FindBy(id = "Select1")
    public WebElement select1_pbl;
    /**
     *会员中心 销售中心 发布产品页面中的产品三级目录
     */
    @FindBy(id = "Select2")
    public WebElement select2_pbl;
    /**
     *会员中心 销售中心 发布产品页面中的产品分类
     */
    @FindBy(name = "GroupList1")
    public WebElement grouplist_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的产品名称
     */
    @FindBy(id = "ProTitle")
    public WebElement protitle_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的产品型号
     */
    @FindBy(name = "ItemNo")
    public WebElement itemno_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的产品品牌
     */
    @FindBy(name = "BrandName")
    public WebElement bradname_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的产品原价
     */
    @FindBy(name = "OrigPrice")
    public WebElement origprice_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的产品现价
     */
    @FindBy(name = "Price")
    public WebElement price_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的供货总量
     */
    @FindBy(name = "Stock")
    public WebElement stock_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的产品主图
     */
    @FindBy(xpath = "//img[@src='/Resources/Img/car_sever_default_w200.jpg']")
    public WebElement img_pdl;
    @FindBy(name = "imgFile")
    public WebElement local_pdl;
    @FindBy(xpath = "//div[@class='ke-dialog-footer']/span[1]/input")
    public WebElement kebut_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的产品描述
     */
    @FindBy(xpath = "//body[@class='ke-content']")
    public WebElement content_pdl;
    /**
     *会员中心 销售中心 发布产品页面中的发布链接
     */
    @FindBy(xpath = "//input[@value='发布']")
    public WebElement submit_pdl;
    /**
     *会员中心 销售中心 发布产品后的提示信息
     */
    @FindBy(xpath = "//div[@class='layui-layer-content layui-layer-padding']")
    public WebElement contentlayu_pdl;

    public Publish(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void productLaunch(String proname){
        business_order.click();
        publish_proinfo.click();
        Select select = new Select(select0_pbl);
        select.selectByValue("11150");
        Select select1 = new Select(select1_pbl);
        select1.selectByValue("11196");
        Select select2 = new Select(select2_pbl);
        select2.selectByValue("12390");
        Select select3 = new Select(grouplist_pdl);
        select3.selectByValue("76140");
        protitle_pdl.sendKeys(proname);
        itemno_pdl.sendKeys("V3");
        bradname_pdl.sendKeys("中汽");
        origprice_pdl.clear();
        origprice_pdl.sendKeys("100");
        price_pdl.clear();
        price_pdl.sendKeys("90");
        stock_pdl.clear();
        stock_pdl.sendKeys("22");
        img_pdl.click();
        local_pdl.sendKeys("C:\\Users\\Administrator\\Desktop\\文档\\测试文件及部分流程\\图片\\3.jpg");

        kebut_pdl.click();

    }

}
