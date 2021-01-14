package com.tasks.pages;

import com.tasks.utilities.BrowserUtils;
import com.tasks.utilities.ConfigurationReader;
import com.tasks.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){

        PageFactory.initElements(Driver.get(),this);
    }

    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url2"));
    }

    public String getPageTitle() {

        return Driver.get().getTitle();
    }

    public WebElement navigateToModule(String module) {

        String moduleLocator = "//a[contains(text(),'"+module+"')]";
       // WebElement moduleElement = Driver.get().findElement(By.xpath(moduleLocator)); -->neden bunu kullanmadik....? ve try/catch uygulama sekli ??
        WebElement moduleElement = null;  //niye null
        try {
            BrowserUtils.waitForClickablility(By.xpath(moduleLocator), 5);
            moduleElement = Driver.get().findElement(By.xpath(moduleLocator));
        } catch (Exception e) {
            e.printStackTrace();
           // BrowserUtils.clickWithWait(By.xpath(moduleLocator), 5);
        }


        return moduleElement;
    }
}
