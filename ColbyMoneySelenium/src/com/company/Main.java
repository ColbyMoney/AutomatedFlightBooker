package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	    // TODO Auto-generated method stub
        System.out.println("hello selenium");
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //navigate to the aa.com webpage
        driver.get("http://aa.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        //select One-Way Trip choice
        driver.findElement(By.xpath("//*[@id=\"bookingCheckboxContainer\"]/div[1]/div[2]/label/span[1]")).click();


        //from section

        //select united states for from
        driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[3]/div[1]/div/a/span[1]")).click();
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\'countryCode\']")));
        dropdown.selectByValue("US");

        //select missouri for from
        dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"stateCode\"]")));
        dropdown.selectByValue("MO");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //select Columbia Regional (COU) for the airport for from
        driver.findElements(By.xpath("//*[@id=\"airport_COU\"]/span[1]")).get(0).click();


        //to section

        //select United States for to
        driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[3]/div[2]/div/a/span[1]")).click();
        dropdown = new Select(driver.findElement(By.xpath("//*[@id=\'countryCode\']")));
        dropdown.selectByValue("US");

        //select California for to
        dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"stateCode\"]")));
        dropdown.selectByValue("CA");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //select San Diego International for the airport for to
        driver.findElements(By.xpath("//*[@id=\"airport_SAN\"]/span[1]")).get(0).click();


        //select 2 for number of passengers
        dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"flightSearchForm.adultOrSeniorPassengerCount\"]")));
        dropdown.selectByValue("2");


        //select 11/27/2021 for the departure date
        driver.findElement(By.xpath("//*[@id=\"aa-leavingOn\"]")).sendKeys("11/27/2021");


        //click the search button
        driver.findElements(By.xpath("//*[@id=\"flightSearchForm.button.reSubmit\"]")).get(0).click();
    }
}