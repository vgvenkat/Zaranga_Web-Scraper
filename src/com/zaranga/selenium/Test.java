package com.zaranga.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Test {
	public static void main(String[] args) throws Exception {
		// The Firefox driver supports javascript, A Head less browser will
		// replace this
		WebDriver driver = new FirefoxDriver();
		driver.get("http://bookings.myrtlebeachoceanfrontvacationrentals.com/Unit/Details/37764");
		// Creates a file called sample.txt
		PrintStream ps = new PrintStream("C:/sample.txt");
		System.setOut(ps);

		List<WebElement> pageSource2 = driver.findElements(By
				.xpath("//div[contains(@class,'ui-datepicker-group')]"));

		System.out.println("pagesource2");

		for (WebElement page : pageSource2) {
			List<WebElement> pagers = page.findElements(By
					.xpath(".//div[@class='ui-datepicker-title']/span"));
			//finds the month and year through relative Xpath
			for (WebElement pager : pagers) {
				System.out.print(" " + pager.getAttribute("innerHTML"));
			}
			List<WebElement> unavailables_local = page.findElements(By
					.xpath(".//td[contains(@class,'ui-state-disabled')]/span"));
			//finds the dates through relative xpath
			System.out.println("----No of booked days:"
					+ unavailables_local.size());

			for (WebElement unavailable : unavailables_local) {

				System.out.println(unavailable.getAttribute("innerHTML"));
			}
		}

		System.out.println("pagesource end");
		ps.close();
		driver.quit();

	}
}