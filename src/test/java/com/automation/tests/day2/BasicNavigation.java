package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

       // to start selenium script we need:
       // setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        // in selenium everything starts from webDriver interface

        driver.get("http://google.com"); // open a website
        driver.manage().window().maximize();// to maximize browser
        //driver.manage().window().fullscreen();


        Thread.sleep(3000); // for demo, wait 3 second

        String title = driver.getTitle();
        String expectedTitle = "Google"; // we provide it
        System.out.println("Title is..."+title);

        if(expectedTitle.equals(title)){
            System.out.println("Test passed!");
        }else{
            System.out.println("Test failed!");
        }
// go to another website within the same window
        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
// come back to google
        driver.navigate().back();
        Thread.sleep(3000);

        // getTitle()- returns title
        verifyEquals(driver.getTitle(), "Google");

        //move forward int the browser history
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("Title: "+driver.getTitle());
        // driver.getTitle() - returns page title of the page that is currently opened

        //must be at the end
        driver.close(); // to close browser


    }

    public static void verifyEquals(String arg1,String arg2){

        if(arg1.equals(arg2)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
    }

}
