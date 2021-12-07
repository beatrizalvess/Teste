package com.telparklogin.pages;

import com.telparklogin.core.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Certificados {
    WebDriver driver;
    Driver driverWeb;

    @Before
    public void inicializaTeste(){
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("https://fpftech.com");
    }
    @Test
    public void allCertificados(){
        try {
            Thread.sleep(1500);
            String principalPage = driver.getWindowHandle();
            String popUp = null;

            Set<String> handles = driver.getWindowHandles();
            Iterator<String> iterator = handles.iterator();
            while (iterator.hasNext()){
                popUp = iterator.next();
            }
            driver.switchTo().window(popUp);
            driver.findElement(By.xpath("//button[2]")).click();
            driver.switchTo().window(principalPage);

            List<String> certificacoes = new ArrayList<String>();
            List<WebElement> element = driver.findElements(By.xpath("//app-home-certifications-card//img"));
            System.out.println("A lista de certificações é:");
            for (Integer i =0; i < element.size(); i++){
                certificacoes.add(element.get(i).getAttribute("alt"));
                System.out.println(element.get(i).getAttribute("alt"));
            }
            String certificacaoBuscada = "Certificação CSM";
            if(certificacoes.contains(certificacaoBuscada)){
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("A Certificação CSM está presente");
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @After
    public void finalizaTeste(){
        driver.quit();
    }
}
