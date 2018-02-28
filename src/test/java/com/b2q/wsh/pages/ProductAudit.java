package com.b2q.wsh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAudit {
    /**
     * 会员中心中的销售中心链接
     */
    @FindBy(xpath = "//a[@href = '/Business/Order']")
    public WebElement business_order;
    /**
     * 销售中心 产品管理链接
     */
    @FindBy(xpath = "//a[@href='/Business/ProductList']")
    public WebElement productlist_cpsh;
    /**
     *产品管理 审核中的产品列表链接
     */
    @FindBy(xpath = "//a[@data-state='0']")
    public WebElement audit_cpsh;
    /**
     * 销售中心 产品管理 审核中的第一个商品单选按钮
     */
    @FindBy(xpath = "//tbody[@id='TBody']/tr[1]/td[1]/input")
    public WebElement checkbox_cpsh;
    /**
     * 销售中心 产品管理 审核中页面 删除按钮
     */
    @FindBy(id = "deleteButton")
    public WebElement deletebut_cpsh;
    /**
     * 销售中心 产品管理 审核中页面 确认删除按钮
     */
    @FindBy(xpath = "//a[@class='layui-layer-btn0']")
    public WebElement laybut_cpsh;
    public ProductAudit(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void deleteProduct(){
        business_order.click();
        productlist_cpsh.click();
        audit_cpsh.click();
        checkbox_cpsh.click();
        deletebut_cpsh.click();
        laybut_cpsh.click();
    }

}
